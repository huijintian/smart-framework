package org.smart.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by mengtian on 2017/11/21
 */
public class PropsUtil {
    public static Properties loadProps(String fileName) {
        Properties properties = null;
        InputStream is = null;
        is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        if (is == null) {
            throw new NullPointerException("fileName can not be null.");
        }
        properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }

    public static String getString(Properties properties, String key) {
        return getString(properties, key, "");
    }

    public static String getString(Properties properties, String key, String defaultValue) {
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        }
        return defaultValue;
    }

    public static int getInt(Properties properties, String key) {
        return getInt(properties, key, 0);
    }

    public static int getInt(Properties properties, String key, int defaultValue) {
        if (properties.containsKey(key)) {
            return Integer.parseInt(properties.getProperty(key));
        }
        return defaultValue;
    }
}
