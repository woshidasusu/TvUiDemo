package com.dasu.tvuidemo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by suxq on 2018/4/26.
 */

public class ScreenEntity implements Serializable {

    private int row;
    private int column;

    private List<ElementEntity> elementList;

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

    public List<ElementEntity> getElementList() {
        if (elementList == null) {
            return new ArrayList<>();
        }
        return elementList;
    }

    public void setElementList(List<ElementEntity> elementList) {
        this.elementList = elementList;
    }
}
