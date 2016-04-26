package ggikko.me.swipetablelayoutversiontwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.rey.material.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ggikko.me.swipetablelayoutversiontwo.adapter.LeftRecyclerViewAdapter;
import ggikko.me.swipetablelayoutversiontwo.adapter.RightRecyclerViewAdapter;
import ggikko.me.swipetablelayoutversiontwo.helper.ItemTouchHelperCallback;
import ggikko.me.swipetablelayoutversiontwo.helper.RecyclerOnScrollListener;
import ggikko.me.swipetablelayoutversiontwo.manager.CustomLinearLayoutManager;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.recycler_left) RecyclerView mRecycler_left;
    @Bind(R.id.recycler_right) RecyclerView mRecycler_right;
    @Bind(R.id.arrow) ImageView arrow;
    @Bind(R.id.table_divider) View table_divider;
    @Bind(R.id.main_scrollview) ScrollView main_scrollview;

    private List<CheckBox> checkboxList = new ArrayList<>();

    private LeftRecyclerViewAdapter mLeftRecyclerViewAdapter;
    private RightRecyclerViewAdapter mRightRecyclerViewAdapter;

    private LinearLayoutManager mLeftRecyclerViewLayoutManager;
    private LinearLayoutManager mRightRecyclerViewLayoutManager;

    private ItemTouchHelper mItemTouchHelper;

    TextView[][] textViews = new TextView[128][128];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** inject view */
        ButterKnife.bind(this);

        /** recyclerView setting*/
        mLeftRecyclerViewAdapter = new LeftRecyclerViewAdapter(this);
        mLeftRecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecycler_left.setLayoutManager(mLeftRecyclerViewLayoutManager);
        mRecycler_left.setAdapter(mLeftRecyclerViewAdapter);

        mRightRecyclerViewAdapter = new RightRecyclerViewAdapter(this);
        mRightRecyclerViewLayoutManager = new CustomLinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        /** item size Cached for stopping recyclerview render again */
        getTestData();
        mLeftRecyclerViewAdapter.setData(loan_id_list);
        mRightRecyclerViewAdapter.setData(pf_grade_list, interest_rate_list, loan_application_termlist_list,
                bad_rate_list, grade_cb_kcb_list, grade_cb_nice_list, dti_list,
                loan_application_amount_list, remain_loan_application_amount_list, fund_start_time_list);

        mRecycler_right.setItemViewCacheSize(12);
        mRecycler_right.setLayoutManager(mRightRecyclerViewLayoutManager);
        mRecycler_right.setAdapter(mRightRecyclerViewAdapter);

        /** set fixed size for drag and drop */
        mRecycler_right.addOnScrollListener(new RecyclerOnScrollListener(this));
        ItemTouchHelper.Callback callback = new ItemTouchHelperCallback(mRightRecyclerViewAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecycler_right);

        //TODO : DATA 받아와서 연동 + 및 투자하기 작동 시켜보기


    }

    public void visibleDivider(String point){
        if(point.equals("start")) {
            table_divider.setVisibility(View.GONE);
            arrow.setVisibility(View.VISIBLE);
        }
        if(point.equals("normal")) {
            table_divider.setVisibility(View.VISIBLE);
            arrow.setVisibility(View.GONE);
        }
    }



    public void setCheckboxList(int position, CheckBox checkBox){
        this.checkboxList.add(position, checkBox);
    }


    public void setTextviews(TextView textView, int position, int i) {
        textViews[position][i] = textView;
    }

}
