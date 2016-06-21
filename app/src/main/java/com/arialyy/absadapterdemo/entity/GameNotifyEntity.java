package com.arialyy.absadapterdemo.entity;

import com.arialyy.absadapter.delegate.AbsDEntity;

/**
 * Created by lyy on 2016/6/21.
 */
public class GameNotifyEntity extends AbsDEntity {
    String imgUrl;
    String gameIcon;
    String title;
    String detail;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getGameIcon() {
        return gameIcon;
    }

    public void setGameIcon(String gameIcon) {
        this.gameIcon = gameIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
