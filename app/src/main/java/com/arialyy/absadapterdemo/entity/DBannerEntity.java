package com.arialyy.absadapterdemo.entity;

import com.arialyy.absadapter.annotation.AbsType;
import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapterdemo.Constance;
import com.arialyy.absadapterdemo.delegate.BannerDelegate;

import java.util.List;

/**
 * Created by lyy on 2016/6/21.
 */
@AbsType(type = Constance.ADAPTER_TYPE.TYPE_BANNER, delegate = BannerDelegate.class)
public class DBannerEntity extends AbsDEntity {
    List<BannerEntity> banners;

    public List<BannerEntity> getBanners() {
        return banners;
    }

    public void setBanners(List<BannerEntity> banners) {
        this.banners = banners;
    }
}
