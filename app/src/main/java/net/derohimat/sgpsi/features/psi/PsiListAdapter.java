package net.derohimat.sgpsi.features.psi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.derohimat.baseapp.ui.adapter.BaseRecyclerAdapter;
import net.derohimat.baseapp.ui.adapter.viewholder.BaseItemViewHolder;
import net.derohimat.sgpsi.R;
import net.derohimat.sgpsi.data.models.ItemsDao;
import net.derohimat.sgpsi.data.models.PsiReadingsType;
import net.derohimat.sgpsi.data.models.ReadingDao;

import butterknife.Bind;

class PsiListAdapter extends BaseRecyclerAdapter<ItemsDao, PsiListAdapter.BakingHolder> {

    private @PsiReadingsType int mId = 0;

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

    public void setSelectedReading(@PsiReadingsType int id) {
        this.mId = id;
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
            ReadingDao reading = PsiListPresenter.filterReading(mId, item);
            assert reading != null;
            String stringBuilder = "National :" + reading.getNational() + "\n" +
                    "Central :" + reading.getCentral() + "\n" +
                    "North :" + reading.getNorth() + "\n" +
                    "West : " + reading.getWest() + "\n" +
                    "South : " + reading.getSouth() + "\n" +
                    "East : " + reading.getEast();

            mTxtTitle.setText(stringBuilder);
            mTxtTimestamp.setText("Created : " + item.getTimestamp());
            mTxtUpdateTimestamp.setText("Last Update : " + item.getUpdateTimestamp());
        }
    }

}
