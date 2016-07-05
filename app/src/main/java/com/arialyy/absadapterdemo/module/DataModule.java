package com.arialyy.absadapterdemo.module;

import android.content.Context;

import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapterdemo.Constance;
import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.base.BaseModule;
import com.arialyy.absadapterdemo.entity.BannerEntity;
import com.arialyy.absadapterdemo.entity.DBannerEntity;
import com.arialyy.absadapterdemo.entity.GameDetailEntity;
import com.arialyy.absadapterdemo.entity.GameNotifyEntity;
import com.arialyy.absadapterdemo.entity.ImgEntity;
import com.arialyy.absadapterdemo.entity.TextEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lyy on 2016/7/5.
 */
public class DataModule extends BaseModule {
    public DataModule(Context context) {
        super(context);
    }

    public void getData_1() {
        List<AbsDEntity> list = new ArrayList<>();
        Random           rd   = new Random();
        for (int i = 0; i < 16; i++) {
            int seed = rd.nextInt(20);
            if (seed < 2) {
                list.add(getBannerEntity());
            } else if (seed < 8) {
                list.add(getGameDetailEntity(i));
            } else {
                list.add(getGameNotifyEntity(i));
            }
        }
        callback(Constance.CODE.RV_LIST_DATA, list);
    }

    public void getData_2() {
        List<AbsDEntity> list = new ArrayList<>();
        Random           rd   = new Random();
        for (int i = 0; i < 20; i++) {
            int seed = rd.nextInt(20);
            if (seed < 4) {
                list.add(getTextEntity(i));
            } else if (seed < 8) {
                list.add(getImgEntity(i));
            } else if (seed < 12) {
                list.add(getGameDetailEntity(i));
            } else if (seed < 18) {
                list.add(getGameDetailEntity(i));
            } else {
                list.add(getBannerEntity());
            }
        }
        callback(Constance.CODE.RV_LIST_DATA, list);
    }

    public void getData_3() {
        List<AbsDEntity> list = new ArrayList<>();
        Random           rd   = new Random();
        for (int i = 0; i < 20; i++) {
            if (rd.nextBoolean()) {
                list.add(getGameDetailEntity(i));
            } else {
                list.add(getGameNotifyEntity(i));
            }
        }
        callback(Constance.CODE.RV_LIST_DATA, list);
    }


    private TextEntity getTextEntity(int i) {
        TextEntity tEntity = new TextEntity();
        tEntity.setText("text ==> " + i);
        return tEntity;
    }

    private ImgEntity getImgEntity(int i) {
        ImgEntity iEntity = new ImgEntity();
        iEntity.setText("img ==> " + i);
        return iEntity;
    }

    private GameDetailEntity getGameDetailEntity(int i) {
        GameDetailEntity gEntity = new GameDetailEntity();
        gEntity.setImgUrl("http://tse1.mm.bing.net/th?&id=OIP.M5b16aea3764f2f636268b01588fd48c9o0&w=300&h=300&c=0&pid=1.9&rs=0&p=0");
        gEntity.setTitle("游戏标题_" + i);
        gEntity.setDetail("游戏详情_" + i);
        return gEntity;
    }

    private GameNotifyEntity getGameNotifyEntity(int i) {
        GameNotifyEntity nEntity = new GameNotifyEntity();
        nEntity.setImgUrl("http://tse1.mm.bing.net/th?&id=OIP.Mca2083c7ad029080a4a23fc9b5a875b5o0&w=299&h=282&c=0&pid=1.9&rs=0&p=0");
        nEntity.setTitle("通知标题_" + i);
        nEntity.setDetail("通知详情_" + i);
        nEntity.setGameIcon("http://tse3.mm.bing.net/th?id=OIP.M08cfeabbc820dee0babc342129204e77o0&w=197&h=147&c=7&rs=1&qlt=90&o=4&pid=1.1");
        return nEntity;
    }

    private DBannerEntity getBannerEntity() {
        DBannerEntity      entity = new DBannerEntity();
        List<BannerEntity> list   = new ArrayList<>();
        String[] imgs = new String[]{
                "http://img3.imgtn.bdimg.com/it/u=4122605147,3442563530&fm=21&gp=0.jpg",
                "http://img0.imgtn.bdimg.com/it/u=2262462250,3917059626&fm=21&gp=0.jpg",
                "http://img3.imgtn.bdimg.com/it/u=1396309984,3574511697&fm=21&gp=0.jpg",
                "http://img1.imgtn.bdimg.com/it/u=3397242425,487060046&fm=21&gp=0.jpg"
        };
        for (String img : imgs) {
            BannerEntity bEntity = new BannerEntity();
            bEntity.setImgUrl(img);
            list.add(bEntity);
        }
        entity.setBanners(list);
        return entity;
    }

}
