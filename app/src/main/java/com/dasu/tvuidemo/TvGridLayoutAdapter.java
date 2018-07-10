package com.dasu.tvuidemo;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dasu.tv.TvGridLayout;
import com.dasu.tv.helper.CutNineDrawable;
import com.dasu.tvuidemo.entity.ElementEntity;
import com.dasu.tvuidemo.entity.MenuEntity;
import com.dasu.utils.ScaleViewUtils;

/**
 * Created by suxq on 2018/4/28.
 */

public class TvGridLayoutAdapter extends TvGridLayout.Adapter {

    private Context mContext;
    private MenuEntity mGridMenuEntity;

    public TvGridLayoutAdapter(Context context, MenuEntity menu) {
        mContext = context;
        mGridMenuEntity = menu;
    }

    @Override
    public int getPageRow(int pageIndex) {
        if (mGridMenuEntity == null) {
            return 0;
        }
        return mGridMenuEntity.getScreenList().get(pageIndex).getRow();
    }

    @Override
    public int getPageColumn(int pageIndex) {
        if (mGridMenuEntity == null) {
            return 0;
        }
        return mGridMenuEntity.getScreenList().get(pageIndex).getColumn();
    }

    @Override
    public TvGridLayout.ItemCoordinate getChildCoordinate(int pageIndex, int childIndex) {
        ElementEntity element =
                mGridMenuEntity.getScreenList().get(pageIndex).getElementList().get(childIndex);

        if (element.getX() == 0 && element.getY() == 0
                && element.getRow() == 0 && element.getColumn() == 0) {
            return null;
        }
        TvGridLayout.ItemCoordinate coordinate = new TvGridLayout.ItemCoordinate();
        int left = element.getX() - 1;
        int top = element.getY() - 1;
        int rows = element.getRow();
        int column = element.getColumn();
        coordinate.start = new Point(left, top);
        coordinate.end = new Point(left + column, top + rows);
        return coordinate;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, int childW, int childH) {
        ElementEntity element = mGridMenuEntity.getScreenList().get(groupPosition).getElementList().get(childPosition);

        if (TextUtils.isEmpty(element.getImgUrl())) {
            return null;
        }

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_gridlayout_card, null);
        view.setFocusable(true);
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    ScaleViewUtils.scaleUp(v, 1.03f);
                    v.setBackground(new CutNineDrawable(mContext, R.drawable.bg_card_focused));
                } else {
                    ScaleViewUtils.scaleDown(v);
                    v.setBackground(new CutNineDrawable(mContext, R.drawable.bg_button_normal));
                }
            }
        });
        view.setBackground(new CutNineDrawable(mContext, R.drawable.bg_button_normal));
        ImageView imageView = view.findViewById(R.id.iv_main_item_picture);
        Glide.with(mContext)
                .load(element.getImgUrl())
                .into(imageView);
        return view;
    }

    @Override
    public int getChildCount(int pageIndex) {
        if (mGridMenuEntity == null) {
            return 0;
        }
        return mGridMenuEntity.getScreenList().get(pageIndex).getElementList().size();
    }

    @Override
    public int getPageCount() {
        if (mGridMenuEntity == null) {
            return 0;
        }
        return mGridMenuEntity.getScreenList().size();
    }
}
