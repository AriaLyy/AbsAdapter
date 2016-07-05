package com.arialyy.absadapterdemo.entity;

import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapterdemo.Constance;

/**
 * Created by lyy on 2016/5/30.
 */
public class TextEntity extends AbsDEntity {
    String text;

    public String getText() {
        return text;
    }

    @Override
    public int getAbsType() {
        return Constance.ADAPTER_TYPE.TYPE_TEXT;
    }

    public void setText(String text) {
        this.text = text;
    }
}
