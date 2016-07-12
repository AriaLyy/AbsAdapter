package com.arialyy.absadapter;

/**
 * Created by lyy on 2016/7/11.
 */
public class AbsConstance {

    public static class PATH {
        private static final String rootPath = System.getProperty("user.dir") + "/cache/build/";
        public static final String TEMP_PARAMS_PATH = rootPath + "mPro.properties";
    }

    public static class KEY {
        public static final String CLASS_NAME = "CLASS_NAME";
        public static final String CLASS_TYPE = "CLASS_TYPE";
    }

    public static class PARAMS {
        public static final String CLASS_NAME = "CLASS_NAME";
        public static final String CLASS_TYPE = "CLASS_TYPE";
        public static final String CONFIG_CLASS_NAME = "AbsParamsTemp";
        public static final String TEMP_CLASS_PACKAGE = "com.arialyy.temp";
    }

}
