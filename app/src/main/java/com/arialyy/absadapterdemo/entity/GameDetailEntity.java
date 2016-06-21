package com.arialyy.absadapterdemo.entity;

import com.arialyy.absadapter.delegate.AbsDEntity;

/**
 * Created by lyy on 2016/6/21.
 */
public class GameDetailEntity extends AbsDEntity{
    String imgUrl;
    String title;
    String detail;

    public String getImgUrl() {
        return imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }
}
