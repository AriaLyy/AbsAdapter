package com.arialyy.absadapterdemo.entity;

import com.arialyy.absadapter.delegate.AbsDEntity;

import java.util.List;

/**
 * Created by lyy on 2016/6/21.
 */
public class DBannerEntity extends AbsDEntity {
    List<BannerEntity> banners;

    public List<BannerEntity> getBanners() {
        return banners;
    }

    public void setBanners(List<BannerEntity> banners) {
        this.banners = banners;
    }
}
