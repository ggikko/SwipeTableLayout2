package ggikko.me.swipetablelayoutversiontwo.helper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import ggikko.me.swipetablelayoutversiontwo.MainActivity;

/**
 * Created by ggikko on 16. 4. 13..
 */
public class RecyclerOnScrollListener extends RecyclerView.OnScrollListener {

    private Context mContext;

    int firstCompleteItem;

    RecyclerViewPositionHelper mRecyclerViewHelper;

    public RecyclerOnScrollListener(Context context) {
        this.mContext = context;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        mRecyclerViewHelper = RecyclerViewPositionHelper.createHelper(recyclerView);
        firstCompleteItem= mRecyclerViewHelper.findFirstCompletelyVisibleItemPosition();

        Log.e("ggikko", "dx : " + dx + "dy : " + dy);

        if(firstCompleteItem == 0){
            ((MainActivity)mContext).visibleDivider("start");
        }else{
            ((MainActivity)mContext).visibleDivider("normal");
        }

    }

}
