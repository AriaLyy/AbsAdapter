package com.arialyy.absadapter.core;

/**
 * Created by lyy on 2016/7/11.
 */
public class Bean {
    int type;
    String adapterPath;
    String entityPath;

    public String getEntityPath() {
        return entityPath;
    }

    public void setEntityPath(String entityPath) {
        this.entityPath = entityPath;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAdapterPath() {
        return adapterPath;
    }

    public void setAdapterPath(String adapterPath) {
        this.adapterPath = adapterPath;
    }
}
