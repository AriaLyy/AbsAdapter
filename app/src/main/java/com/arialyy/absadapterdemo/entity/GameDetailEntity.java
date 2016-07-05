package com.arialyy.absadapterdemo.entity;

import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapterdemo.Constance;

/**
 * Created by lyy on 2016/6/21.
 */
public class GameDetailEntity extends AbsDEntity{
    String imgUrl;
    String title;
    String detail;

    @Override
    public int getAbsType() {
        return Constance.ADAPTER_TYPE.TYPE_GAME_DETAIL;
    }

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
