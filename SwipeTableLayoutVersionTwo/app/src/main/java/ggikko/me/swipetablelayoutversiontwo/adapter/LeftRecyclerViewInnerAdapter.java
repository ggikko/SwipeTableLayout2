package ggikko.me.swipetablelayoutversiontwo.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rey.material.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ggikko.me.swipetablelayoutversiontwo.MainActivity;
import ggikko.me.swipetablelayoutversiontwo.R;

/**
 * Created by admin on 16. 4. 25..
 */
public class LeftRecyclerViewInnerAdapter extends RecyclerView.Adapter<LeftRecyclerViewInnerAdapter.LeftSideInnerViewHolder> {

    List<String> loan_id_list = new ArrayList<>();
    Context mContext;

    public LeftRecyclerViewInnerAdapter(List<String> loan_id_list, Context context) {
        this.loan_id_list = loan_id_list;
        this.mContext = context;
    }

    private List<CheckBox> checkboxList = new ArrayList<>();

    @Override
    public LeftSideInnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        parent.setClipChildren(false);
        parent.setClipToPadding(false);
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.invest_left_inner_row,parent,false);
        parent.setClipChildren(false);
        parent.setClipToPadding(false);
        return new LeftSideInnerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LeftSideInnerViewHolder holder, int position) {

        /** header */
        if(position ==0){
            holder.left_root_layout.setBackgroundColor(ContextCompat.getColor(mContext, R.color.header));
        }else {
            holder.loan_id.setText(loan_id_list.get(position));
        }

        ((MainActivity)mContext).setCheckboxList(position, holder.left_checkbox);
        checkboxList.add(holder.left_checkbox);
    }

    @Override
    public int getItemCount() {
        return loan_id_list.size();
    }

    /** left side viewholder */
    public class LeftSideInnerViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.loan_id)
        TextView loan_id;
        @Bind(R.id.left_root_layout)
        LinearLayout left_root_layout;
        @Bind(R.id.value) LinearLayout value;
        @Bind(R.id.left_checkbox) CheckBox left_checkbox;

        @OnClick(R.id.left_checkbox)
        void callCheck(){

            if(left_checkbox == checkboxList.get(0)){
                for(CheckBox checkBox : checkboxList){
                    if(left_checkbox.isChecked()) {
                        checkBox.setChecked(true);
                    }else{
                        checkBox.setChecked(false);
                    }
                }
            }
        }

        public LeftSideInnerViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
