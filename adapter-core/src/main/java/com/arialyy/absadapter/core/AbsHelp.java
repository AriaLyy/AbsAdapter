package com.arialyy.absadapter.core;

import com.arialyy.absadapter.AbsConstance;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by lyy on 2016/7/11.
 * Abs注解帮助类
 */
public class AbsHelp {
    private static volatile AbsHelp INSTANCE = null;

    private static final Object LOCK = new Object();
    private Map<String, Bean> mData = new HashMap<>();
//    private Set<String> mData = new HashSet<>();

    public static AbsHelp getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                INSTANCE = new AbsHelp();
            }
        }
        return INSTANCE;
    }

    private AbsHelp() {
        init();
    }

    /**
     * 初始化工具
     */
    private void init() {
        Class tempClass = getTempClazz();
        if (tempClass != null) {
            Field[] fields = tempClass.getFields();
            try {
                for (Field f : fields) {
                    String value = f.get(tempClass) + "";
                    String[] values = value.split(",");

                    String key = f.getName();
                    Bean b = new Bean();
                    b.setType(Integer.parseInt(values[0]));
                    b.setAdapterPath(values[1]);
                    b.setEntityPath(key);
                    mData.put(values[2], b);
                    mData.put(values[1], b);
//                    mData.add(value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取所有数据
     */
    public Map<String, Bean> getData() {
        return mData;
    }

    /**
     * 获取实体type
     *
     * @param clazz 实体Class，或者Delegate Class
     * @return
     */
    public int getType(Class clazz) {
        return mData.get(clazz.getName()).getType();
    }

    /**
     * 获取对应的Adapter路径
     *
     * @param clazz 实体clazz，或者Delegate Class
     * @return
     */
    public String getAdapterPath(Class clazz) {
        return mData.get(clazz.getName()).getAdapterPath();
    }

    private Class getTempClazz() {
        try {
            return Class.forName(AbsConstance.PARAMS.TEMP_CLASS_PACKAGE + "." + AbsConstance.PARAMS.CONFIG_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
