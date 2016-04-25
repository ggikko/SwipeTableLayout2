package ggikko.me.swipetablelayoutversiontwo.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindColor;
import butterknife.BindDrawable;
import butterknife.ButterKnife;
import ggikko.me.swipetablelayoutversiontwo.MainActivity;
import ggikko.me.swipetablelayoutversiontwo.R;
import ggikko.me.swipetablelayoutversiontwo.helper.ItemTouchHelperAdapter;
import ggikko.me.swipetablelayoutversiontwo.helper.ItemTouchHelperViewHolder;

/**
 * Created by admin on 16. 4. 25..
 */
public class RightRecyclerViewAdapter extends RecyclerView.Adapter<RightRecyclerViewAdapter.RightSideViewHolder> implements ItemTouchHelperAdapter {

    List<String> pf_grade_list = new ArrayList<>();
    List<String> interest_rate_list = new ArrayList<>();
    List<String> loan_application_termlist_list = new ArrayList<>();
    List<String> bad_rate_list = new ArrayList<>();
    List<String> grade_cb_kcb_list = new ArrayList<>();
    List<String> grade_cb_nice_list = new ArrayList<>();
    List<String> dti_list = new ArrayList<>();
    List<String> loan_application_amount_list = new ArrayList<>();
    List<String> remain_loan_application_amount_list = new ArrayList<>();
    List<String> fund_start_time_list = new ArrayList<>();

    TextView textView;

    LinearLayout right_item;

    RecyclerView recycler_right_inner;

    int renderingPosition = 0;

    private Context mContext;

    public RightRecyclerViewAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<String> pf_grade_list, List<String> interest_rate_list,
                        List<String> loan_application_termlist_list, List<String> bad_rate_list,
                        List<String> grade_cb_kcb_list, List<String> grade_cb_nice_list,
                        List<String> dti_list, List<String> loan_application_amount_list,
                        List<String> remain_loan_application_amount_list, List<String> fund_start_time_list) {

        this.pf_grade_list = pf_grade_list;
        this.interest_rate_list = interest_rate_list;
        this.loan_application_amount_list = loan_application_amount_list;
        this.loan_application_termlist_list = loan_application_termlist_list;
        this.bad_rate_list = bad_rate_list;
        this.grade_cb_kcb_list = grade_cb_kcb_list;
        this.grade_cb_nice_list = grade_cb_nice_list;
        this.dti_list = dti_list;
        this.remain_loan_application_amount_list = remain_loan_application_amount_list;
        this.fund_start_time_list = fund_start_time_list;

    }


    @Override
    public RightSideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.invest_right_row,parent,false);

        return new RightSideViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RightSideViewHolder holder, int position) {

        for(int i =1; i<70; i++) {

            float GESTURE_THRESHOLD_DP = 35.0f;
            float GESTURE_THRESHOLD_DP2 = 90.0f;
            final float scale = mContext.getResources().getDisplayMetrics().density;
            int px = (int) (GESTURE_THRESHOLD_DP * scale + 0.5f);
            int px2 = (int) (GESTURE_THRESHOLD_DP2 * scale + 0.5f);

            textView = new TextView(mContext);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(px2, px);


            textView.setLayoutParams(layoutParams);
            textView.setText("i"+(i-1)+","+"p"+position);
            textView.setTextSize(13);
            textView.setPadding(0, 0, 0, 0);
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            textView.setBackgroundResource(R.drawable.background_border);

            ((MainActivity)mContext).setTextviews(textView, position, i);

            right_item.addView(textView);
        }

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 11;
    }

    /** helper overriding */
    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        notifyItemRemoved(position);
    }


    /** right side viewholder */
    public class RightSideViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {

        @BindDrawable(R.drawable.background_leftright_border) Drawable background_leftright_border;
        @BindDrawable(R.drawable.background_leftright_delete) Drawable background_leftright_delete;
        @BindDrawable(R.drawable.background_border) Drawable background_border;
        @BindColor(R.color.white) int white;

        public RightSideViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            right_item = (LinearLayout) itemView.findViewById(R.id.right_item);

        }

        @Override
        public void onItemSelected() {
        }

        @Override
        public void onItemClear() {
        }

    }
}