package ggikko.me.swipetablelayoutversiontwo.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
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


    TextView textView;
    View view;

    LinearLayout right_item;

    RecyclerView recycler_right_inner;

    int renderingPosition = 0;

    private Context mContext;

    public RightRecyclerViewAdapter(Context context) {
        this.mContext = context;
    }

 

    @Override
    public RightSideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.invest_right_row,parent,false);

        return new RightSideViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RightSideViewHolder holder, int position) {

        float GESTURE_THRESHOLD_DP = 34.0f;
        float GESTURE_THRESHOLD_DP2 = 90.0f;
        final float scale = mContext.getResources().getDisplayMetrics().density;
        int height = (int) (GESTURE_THRESHOLD_DP * scale + 0.5f);
        int width = (int) (GESTURE_THRESHOLD_DP2 * scale + 0.5f);

        float GESTURE_THRESHOLD_DP3 = 1.0f;
        int height2 = (int) (GESTURE_THRESHOLD_DP3 * scale + 0.5f);

        for(int i =1; i<50; i++) {

            if(i ==1){
                /** 아무것도 없는 header 부분 */
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(width, height2);
                view = new View(mContext);
                view.setLayoutParams(layoutParams2);
                view.setBackgroundResource(R.drawable.bottom_line);
                right_item.addView(view);

                textView = new TextView(mContext);
                textView.setLayoutParams(layoutParams);
                textView.setText("title");
                textView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.header));
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                right_item.addView(textView);
            }else if(i ==2){
                /** 등급 부분 */

                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(width, height2);
                view = new View(mContext);
                view.setLayoutParams(layoutParams2);
                view.setBackgroundResource(R.drawable.bottom_line);
                right_item.addView(view);
                textView = new TextView(mContext);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                layoutParams.setMargins(10,10,10,10);
                textView.setLayoutParams(layoutParams);
                textView.setText("B2");
                textView.setTextColor(ContextCompat.getColor(mContext, R.color.white));
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                textView.setBackgroundResource(R.drawable.bgrade_background);
                right_item.addView(textView);
            }else if (i ==3){
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(width, height2);
                view = new View(mContext);
                view.setLayoutParams(layoutParams2);
                view.setBackgroundResource(R.drawable.bottom_line);
                right_item.addView(view);

                textView = new TextView(mContext);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                textView.setLayoutParams(layoutParams);
                textView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.header));
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                right_item.addView(textView);
            }else if (i ==4){

            }else{
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(width, height2);
                view = new View(mContext);
                view.setLayoutParams(layoutParams2);
                view.setBackgroundResource(R.drawable.bottom_line);
                right_item.addView(view);

                textView = new TextView(mContext);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                textView.setLayoutParams(layoutParams);
                textView.setText("i" + (i - 1) + "," + "p" + position);
                textView.setTextSize(13);
                textView.setPadding(0, 0, 0, 0);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                textView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));


//                textView.setBackgroundResource(R.drawable.background_border);

                ((MainActivity) mContext).setTextviews(textView, position, i);

                right_item.addView(textView);
            }
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