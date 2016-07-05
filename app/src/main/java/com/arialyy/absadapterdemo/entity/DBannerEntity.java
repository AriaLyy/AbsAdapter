package com.arialyy.absadapterdemo.entity;

import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapterdemo.Constance;

import java.util.List;

/**
 * Created by lyy on 2016/6/21.
 */
public class DBannerEntity extends AbsDEntity {
    List<BannerEntity> banners;

    @Override
    public int getAbsType() {
        return Constance.ADAPTER_TYPE.TYPE_BANNER;
    }

    public List<BannerEntity> getBanners() {
        return banners;
    }

    public void setBanners(List<BannerEntity> banners) {
        this.banners = banners;
    }
}
