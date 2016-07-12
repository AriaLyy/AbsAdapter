package com.arialyy.absadapter.core;

import com.arialyy.absadapter.AbsConstance;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.tools.Diagnostic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by lyy on 2016/5/26.
 * 工具类
 */
public class AbsCoreUtil {

    private AbsCoreUtil INSTANCE = null;
    private Messager mMessager;
    private Filer mFiler;

    public AbsCoreUtil(ProcessingEnvironment processingEnv) {
        mMessager = processingEnv.getMessager();
        mFiler = processingEnv.getFiler();
    }

    public void error(Element e, String msg, Object... args) {
        mMessager.printMessage(Diagnostic.Kind.ERROR, String.format(msg, args), e);
    }

    public void error(String msg, Object... args) {
        mMessager.printMessage(Diagnostic.Kind.ERROR, String.format(msg, args));
    }

    public void print(String str) {
        mMessager.printMessage(Diagnostic.Kind.NOTE, str);
    }

    /**
     * 创建插件参数java文件
     */
    public void createPluginParamsJF() {
        TypeSpec.Builder tb = TypeSpec.classBuilder(AbsConstance.PARAMS.CONFIG_CLASS_NAME)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL);
        File file = new File(AbsConstance.PATH.TEMP_PARAMS_PATH);
        if (file.exists()) {
            Properties pro = loadConfig(file);

            Enumeration e = pro.propertyNames();
            while (e.hasMoreElements()) {
                String entityPath = (String) e.nextElement();
                String value = pro.getProperty(entityPath, "");
                if (value.equals("")) {
                    error("value不能为空");
                    return;
                }
                if (entityPath.contains(".")) {
                    entityPath = entityPath.replace(".", "_");
                }
                tb.addField(createField(entityPath, value));
            }

        } else {
            print("pro 文件不存在");
        }

        JavaFile jf = JavaFile.builder(AbsConstance.PARAMS.TEMP_CLASS_PACKAGE, tb.build()).build();
        print(jf.toString());
        try {
            jf.writeTo(mFiler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private FieldSpec createField(String name, String value) {
        return FieldSpec.builder(String.class, name)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer("$S", value).build();
    }

    /**
     * 读取配置文件
     *
     * @param file
     * @return
     */
    public synchronized Properties loadConfig(File file) {
        Properties properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    /**
     * 保存配置文件
     *
     * @param file
     * @param properties
     */
    public synchronized void saveConfig(File file, Properties properties) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file, false);
            properties.store(fos, null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.flush();
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
