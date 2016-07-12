package com.arialyy.absadapterdemo.entity;

import com.arialyy.absadapter.annotation.AbsType;
import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapterdemo.Constance;
import com.arialyy.absadapterdemo.delegate.TextDelegate;

/**
 * Created by lyy on 2016/5/30.
 */
@AbsType(type = Constance.ADAPTER_TYPE.TYPE_TEXT, delegate = TextDelegate.class)
public class TextEntity extends AbsDEntity {
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
