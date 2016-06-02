package com.arialyy.absadapterdemo.entity;

import com.arialyy.absadapter.delegate.AbsDEntity;

/**
 * Created by lyy on 2016/5/30.
 */
public class ImgEntity extends AbsDEntity{
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
