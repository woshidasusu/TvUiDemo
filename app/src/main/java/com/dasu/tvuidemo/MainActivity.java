package com.dasu.tvuidemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dasu.tvuidemo.entity.LayoutEntity;
import com.dasu.utils.FileUtils;
import com.dasu.utils.LogUtils;
import com.google.gson.Gson;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by suxq on 2018/7/10.
 */

public class MainActivity extends FragmentActivity {
    private static final String TAG = "MainActivity";

    private LayoutEntity mLayoutEntity;

    @InjectView(R.id.tab_main_menu)
    public TabLayout mTabLayout;
    @InjectView(R.id.vp_main_content)
    public ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
        mockLayoutData();
        init();
    }

    private void mockLayoutData() {
        String layout = FileUtils.inputStreamToString(getResources().openRawResource(R.raw.layout));
        mLayoutEntity = new Gson().fromJson(layout, LayoutEntity.class);
    }

    private void init() {
        LogUtils.d(TAG, "data = " + new Gson().toJson(mLayoutEntity));
        mViewPager.setOffscreenPageLimit(mLayoutEntity.getMenuList().size());
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return MainFragment.newInstance(mLayoutEntity.getMenuList().get(position));
            }

            @Override
            public int getCount() {
                return mLayoutEntity.getMenuList().size();
            }
        });
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            final TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(R.layout.item_main_tab_menu);
            final int index = i;
            ViewGroup rootView = (ViewGroup) tab.getCustomView().getParent();
            rootView.setFocusable(true);
            rootView.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
            rootView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        mViewPager.setCurrentItem(index);
                    }
                }
            });
            TextView textView = rootView.findViewById(R.id.tab_text);
            textView.setText(mLayoutEntity.getMenuList().get(i).getMenuName());
            if (i == 0) {
                rootView.requestFocus();
            }
        }
    }
}
