package com.arialyy.absadapter;

/**
 * Created by lyy on 2016/5/30.
 */
public class AbsUtil {

    public static String getClassName(Object obj) {
        String arrays[] = obj.getClass().getName().split("\\.");
        return arrays[arrays.length - 1];
    }
}
