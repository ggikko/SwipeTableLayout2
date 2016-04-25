package ggikko.me.swipetablelayoutversiontwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.TextView;

import com.rey.material.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ggikko.me.swipetablelayoutversiontwo.adapter.LeftRecyclerViewAdapter;
import ggikko.me.swipetablelayoutversiontwo.adapter.RightRecyclerViewAdapter;
import ggikko.me.swipetablelayoutversiontwo.manager.CustomLinearLayoutManager;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.recycler_left) RecyclerView mRecycler_left;
    @Bind(R.id.recycler_right) RecyclerView mRecycler_right;

    private List<CheckBox> checkboxList = new ArrayList<>();

    private LeftRecyclerViewAdapter mLeftRecyclerViewAdapter;
    private RightRecyclerViewAdapter mRightRecyclerViewAdapter;

    private LinearLayoutManager mLeftRecyclerViewLayoutManager;
    private LinearLayoutManager mRightRecyclerViewLayoutManager;

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

        /** set fixed size for drag and drop */

    }

    public void setCheckboxList(int position, CheckBox checkBox){
        this.checkboxList.add(position, checkBox);
    }


    public void setTextviews(TextView textView, int position, int i) {
        textViews[position][i] = textView;
    }

}
