package com.arialyy.absadapterdemo.entity;

import com.arialyy.absadapter.annotation.AbsType;
import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapterdemo.Constance;
import com.arialyy.absadapterdemo.delegate.GameDetailDelegate;

/**
 * Created by lyy on 2016/6/21.
 */
@AbsType(type = Constance.ADAPTER_TYPE.TYPE_GAME_DETAIL, delegate = GameDetailDelegate.class)
public class GameDetailEntity extends AbsDEntity {
    String imgUrl;
    String title;
    String detail;

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

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
