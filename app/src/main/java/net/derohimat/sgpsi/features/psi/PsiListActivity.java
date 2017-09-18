package net.derohimat.sgpsi.features.psi;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import net.derohimat.baseapp.ui.view.BaseRecyclerView;
import net.derohimat.sgpsi.R;
import net.derohimat.sgpsi.data.idlingresources.RecipesIdlingResource;
import net.derohimat.sgpsi.data.models.ItemsDao;
import net.derohimat.sgpsi.data.models.PsiDao;
import net.derohimat.sgpsi.data.models.PsiReadingsType;
import net.derohimat.sgpsi.features.AppBaseActivity;
import net.derohimat.sgpsi.util.DialogFactory;

import butterknife.Bind;

public class PsiListActivity extends AppBaseActivity implements PsiListMvpView {

    @Bind(R.id.recipe_list_recyclerview) BaseRecyclerView mRecyclerView;
    @Bind(R.id.spinner) Spinner spinner;

    @Nullable
    private RecipesIdlingResource idlingResource;

    private ProgressBar mProgressBar = null;
    private PsiListPresenter mPresenter;
    private PsiListAdapter mAdapter;
    private int mGridColumnCount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getComponent().inject(this);
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.psi_activity;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        mGridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        getBaseActionBar().setElevation(0);

        setUpAdapter();
        setUpRecyclerView();
        setUpPresenter();
        setUpSpiner();
    }

    @Override
    public void setUpSpiner() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, @PsiReadingsType int position, long id) {
                mAdapter.setSelectedReading(position);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void setUpPresenter() {
        mPresenter = new PsiListPresenter(this);
        mPresenter.attachView(this);
        mPresenter.getData(true);
    }

    @Override
    public void setUpAdapter() {
        mAdapter = new PsiListAdapter(mContext);
        mAdapter.setOnItemClickListener((view, position) -> {
            ItemsDao itemsDao = mAdapter.getDatas().get(position - 1);
        });
    }

    @Override
    public void setUpRecyclerView() {
        mRecyclerView.setUpAsGrid(mGridColumnCount);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setPullRefreshEnabled(true);
        mRecyclerView.setLoadingMoreEnabled(false);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getData(false);
            }

            @Override
            public void onLoadMore() {
            }
        });
    }

    @Override
    public void showData(PsiDao data) {
        mAdapter.clear();
        mAdapter.addAll(data.getItems());
    }

    @Override
    protected void onDestroy() {
        mPresenter.closeRealm();
        mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showError(Throwable throwable) {
        DialogFactory.createGenericErrorDialog(getContext(), throwable.getMessage()).show();
    }

    @Override
    public void showProgress() {
        if (mProgressBar == null) {
            mProgressBar = DialogFactory.DProgressBar(mContext);
        } else {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        mRecyclerView.refreshComplete();
        mProgressBar.setVisibility(View.GONE);
    }

    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (idlingResource == null) {
            idlingResource = new RecipesIdlingResource();
        }
        return idlingResource;
    }

    @Override
    public Context getContext() {
        return this;
    }
}
