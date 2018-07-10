package com.dasu.tvuidemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by suxq on 2018/3/27.
 * 懒加载
 * {@link #onFragmentFirstVisible() Fragment第一次可见时回调}
 * {@link #onFragmentVisibleChange(boolean) Fragment可见状态发生变化时回调}
 * ps:Fragment第一次可见时，上述两个方法都会回调，后续就只有第二个会被回调
 */

public class BaseFragment extends Fragment {

    private boolean isFirstVisible = true;
    protected boolean isFragmentVisible = false;
    private boolean isVisibleToUser = false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getView() == null) {
            this.isVisibleToUser = isVisibleToUser;
            return;
        }
        if (isFirstVisible && isVisibleToUser) {
            isFirstVisible = false;
            onFragmentFirstVisible();
        }
        if (isFragmentVisible ^ isVisibleToUser) {
            isFragmentVisible = isVisibleToUser;
            onFragmentVisibleChange(isVisibleToUser);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (isFirstVisible && isVisibleToUser) {
            isFirstVisible = false;
            isFragmentVisible = true;
            onFragmentFirstVisible();
            onFragmentVisibleChange(true);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isFirstVisible = true;
        isFragmentVisible = false;
    }

    protected void onFragmentFirstVisible() {

    }

    protected void onFragmentVisibleChange(boolean isVisible) {

    }
}