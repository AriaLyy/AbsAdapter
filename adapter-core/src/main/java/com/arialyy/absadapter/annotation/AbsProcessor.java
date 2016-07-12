package com.arialyy.absadapter.annotation;

import com.arialyy.absadapter.AbsConstance;
import com.arialyy.absadapter.core.AbsCoreUtil;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.type.TypeMirror;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by lyy on 2016/7/11.
 * AbsAdapter扫描器
 */
public class AbsProcessor extends AbstractProcessor {
    private AbsCoreUtil mUtil;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mUtil = new AbsCoreUtil(processingEnv);
        init();
    }

    private void init() {
        File tempF = new File(AbsConstance.PATH.TEMP_PARAMS_PATH);
        if (!tempF.getParentFile().exists()) {
            tempF.getParentFile().mkdirs();
        }
        if (!tempF.exists()) {
            try {
                tempF.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotataions = new LinkedHashSet<String>();
        annotataions.add(AbsType.class.getCanonicalName());
        return annotataions;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        handlerElement(roundEnv);
        mUtil.createPluginParamsJF();
        return true;
    }

    /**
     * 处理所有元素
     *
     * @param roundEnv
     */
    private void handlerElement(RoundEnvironment roundEnv) {
        File tempF = new File(AbsConstance.PATH.TEMP_PARAMS_PATH);
        Properties params = mUtil.loadConfig(tempF);
        for (Element el : roundEnv.getElementsAnnotatedWith(AbsType.class)) {
            ElementKind ek = el.getKind();
            if (ek == ElementKind.CLASS) {
                TypeElement te = (TypeElement) el;
                String entityPath = te.getQualifiedName() + "";
//                mUtil.print("entityPath ==> " + entityPath);
                int type = el.getAnnotation(AbsType.class).type();
//                mUtil.print("type ==> " + type);
                String delegatePath = getValue(te).toString();
//                mUtil.print("delegatePath ==> " + delegatePath);
                params.put(entityPath, type + "," + delegatePath + "," + entityPath);
            }
        }
        mUtil.saveConfig(tempF, params);
    }

    private AnnotationMirror getAnnotationMirror(TypeElement typeElement, Class<?> clazz) {
        String clazzName = clazz.getName();
        for (AnnotationMirror m : typeElement.getAnnotationMirrors()) {
            if (m.getAnnotationType().toString().equals(clazzName)) {
                return m;
            }
        }
        return null;
    }

    private AnnotationValue getAnnotationValue(AnnotationMirror annotationMirror, String key) {
        for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : annotationMirror.getElementValues().entrySet()) {
            if (entry.getKey().getSimpleName().toString().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    /**
     * 获取delegate
     * @param te class or interface
     * @return
     */
    public TypeMirror getValue(TypeElement te) {
        AnnotationMirror am = getAnnotationMirror(te, AbsType.class);
        if (am == null) {
            return null;
        }
        AnnotationValue av = getAnnotationValue(am, "delegate");
        if (av == null) {
            return null;
        } else {
            return (TypeMirror) av.getValue();
        }
    }
}
