package com.arialyy.absadapter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lyy on 2016/7/11.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface AbsType {
//    int value();

    int type() default -1;

    Class delegate();
}
