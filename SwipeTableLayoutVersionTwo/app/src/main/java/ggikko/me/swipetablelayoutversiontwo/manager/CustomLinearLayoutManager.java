package ggikko.me.swipetablelayoutversiontwo.manager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by admin on 16. 4. 25..
 */

public class CustomLinearLayoutManager extends LinearLayoutManager {

    private boolean isScrollEnabled = true;

    public CustomLinearLayoutManager(Context context) {
        super(context);
    }

    public CustomLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        return isScrollEnabled && super.canScrollVertically();
    }

    @Override
    public boolean isSmoothScrollbarEnabled() {
        return true;
    }

    @Override
    public void setSmoothScrollbarEnabled(boolean enabled) {
        super.setSmoothScrollbarEnabled(true);
    }

}

