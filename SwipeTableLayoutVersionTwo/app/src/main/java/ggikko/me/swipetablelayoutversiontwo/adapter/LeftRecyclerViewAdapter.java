package ggikko.me.swipetablelayoutversiontwo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ggikko.me.swipetablelayoutversiontwo.R;
import ggikko.me.swipetablelayoutversiontwo.manager.CustomLinearLayoutManager;

/**
 * Created by admin on 16. 4. 25..
 */
public class LeftRecyclerViewAdapter extends RecyclerView.Adapter<LeftRecyclerViewAdapter.LeftSideViewHolder> {

    private static LeftRecyclerViewInnerAdapter mLeftRecyclerViewInnerAdapter;
    private static CustomLinearLayoutManager mLeftInnerRecyclerViewLayoutManager;

    private Context mContext;
    List<String> loan_id_list = new ArrayList<>();

    public LeftRecyclerViewAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> loan_id_list) {
        this.loan_id_list = loan_id_list;
    }

    @Override
    public LeftSideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.invest_left_row,parent,false);

        return new LeftSideViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LeftSideViewHolder holder, int position) {

    }

    /** 왼쪽 행 개수 */
    @Override
    public int getItemCount() {
        return 1;
    }

    /** left side viewholder */
    public class LeftSideViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.recycler_left_inner) RecyclerView recycler_left_inner;

        public LeftSideViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            mLeftRecyclerViewInnerAdapter = new LeftRecyclerViewInnerAdapter(loan_id_list, mContext);
            mLeftInnerRecyclerViewLayoutManager = new CustomLinearLayoutManager(mContext);
            mLeftInnerRecyclerViewLayoutManager.setScrollEnabled(false);
            recycler_left_inner.setLayoutManager(mLeftInnerRecyclerViewLayoutManager);
            recycler_left_inner.setAdapter(mLeftRecyclerViewInnerAdapter);
        }
    }
}
