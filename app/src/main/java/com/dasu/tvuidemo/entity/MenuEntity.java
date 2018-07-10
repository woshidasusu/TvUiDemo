package com.dasu.tvuidemo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by suxq on 2018/4/26.
 */

public class MenuEntity implements Serializable {

    private String menuName;
    private List<ScreenEntity> screenList;

    public List<ScreenEntity> getScreenList() {
        if (screenList == null) {
            return new ArrayList<>();
        }
        return screenList;
    }

    public void setScreenList(List<ScreenEntity> screenList) {
        this.screenList = screenList;
    }

    public String getMenuName() {
        return menuName == null ? "" : menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
