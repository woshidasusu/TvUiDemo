package com.dasu.tvuidemo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suxq on 2018/4/26.
 */

public class LayoutEntity {
    private List<MenuEntity> menuList;

    public List<MenuEntity> getMenuList() {
        if (menuList == null) {
            return new ArrayList<>();
        }
        return menuList;
    }

    public void setMenuList(List<MenuEntity> menuList) {
        this.menuList = menuList;
    }
}
