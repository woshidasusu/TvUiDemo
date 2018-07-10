package com.dasu.tvuidemo.entity;

import java.io.Serializable;

/**
 * Created by suxq on 2018/4/26.
 */

public class ElementEntity implements Serializable {

    private int x;//卡位坐标
    private int y;//卡位坐标
    private int row;//卡位长度
    private int column;//卡位宽度

    private String imgUrl;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getImgUrl() {
        return imgUrl == null ? "" : imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
