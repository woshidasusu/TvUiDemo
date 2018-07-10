package com.dasu.tvuidemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dasu.tv.TvGridLayout;
import com.dasu.tvuidemo.entity.MenuEntity;

/**
 * Created by suxq on 2018/4/28.
 */

public class MainFragment extends BaseFragment {
    private static final String TAG = "MainFragment";

    private static final String PARAM_GRID_MENU = "param_grid_menu";

    private MenuEntity mGridMenuEntity;

    public TvGridLayout mTvGridLayout;
    public TvGridLayoutAdapter mTvGridLayoutAdapter;

    public static MainFragment newInstance(MenuEntity menu) {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(PARAM_GRID_MENU, menu);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mGridMenuEntity = (MenuEntity) getArguments().get(PARAM_GRID_MENU);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mTvGridLayout = view.findViewById(R.id.tgl_main_content);
        mTvGridLayoutAdapter = new TvGridLayoutAdapter(getContext(), mGridMenuEntity);
        mTvGridLayout.setAdapter(mTvGridLayoutAdapter);
        mTvGridLayout.setItemSpace(15);
        return view;
    }

    @Override
    protected void onFragmentFirstVisible() {
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        if (isVisible) {
            mTvGridLayout.setVisibility(View.VISIBLE);
        } else {
            mTvGridLayout.scrollToPage(0, false);
            mTvGridLayout.setVisibility(View.GONE);
        }
    }
}
