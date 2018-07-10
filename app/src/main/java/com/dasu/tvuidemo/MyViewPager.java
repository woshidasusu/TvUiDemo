package com.dasu.tvuidemo;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

import com.dasu.utils.LogUtils;

/**
 * Created by suxq on 2018/7/10.
 */

public class MyViewPager extends ViewPager {
    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean executeKeyEvent(KeyEvent event) {
        return false;
    }

    @Override
    public View focusSearch(View focused, int direction) {
        LogUtils.d("!!!!!!!!!!", "focused=" + focused + ", dir=" + direction + ", has=" + hasFocus());

        View view = super.focusSearch(focused, direction);
        LogUtils.d("!!!!!!!!!!", "new=" + view + ", has=" + hasFocus());
        return super.focusSearch(focused, direction);
    }
}
