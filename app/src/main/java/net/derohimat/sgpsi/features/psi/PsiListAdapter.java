package net.derohimat.sgpsi.features.psi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import net.derohimat.baseapp.ui.adapter.BaseRecyclerAdapter;
import net.derohimat.baseapp.ui.adapter.viewholder.BaseItemViewHolder;
import net.derohimat.sgpsi.R;
import net.derohimat.sgpsi.data.models.ItemsDao;

import butterknife.Bind;

class PsiListAdapter extends BaseRecyclerAdapter<ItemsDao, PsiListAdapter.BakingHolder> {

    PsiListAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemResourceLayout(int viewType) {
        return R.layout.item_reading;
    }

    @Override
    public BakingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BakingHolder(mContext, getView(parent, viewType), mItemClickListener, mLongItemClickListener);
    }

    class BakingHolder extends BaseItemViewHolder<ItemsDao> {

        @Bind(R.id.tv_data) TextView mTxtTitle;
        @Bind(R.id.tv_timestamp) TextView mTxtTimestamp;
        @Bind(R.id.tv_update_timestamp) TextView mTxtUpdateTimestamp;

        BakingHolder(Context context, View itemView, BaseRecyclerAdapter.OnItemClickListener itemClickListener,
                     BaseRecyclerAdapter.OnLongItemClickListener longItemClickListener) {
            super(itemView, itemClickListener, longItemClickListener);
            this.mContext = context;
        }

        @Override
        public void bind(ItemsDao item) {
            String reading = new Gson().toJson(item.getReadings());
            mTxtTitle.setText(reading);
            mTxtTimestamp.setText("Created : " + item.getTimestamp());
            mTxtUpdateTimestamp.setText("Last Update : " + item.getUpdateTimestamp());
        }
    }

}
