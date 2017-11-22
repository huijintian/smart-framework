package org.smart.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by mengtian on 2017/11/22
 */
public final class ReflectionUtil {

    public static Object newInstance(Class<?> cls) {
        try {
            Object instance = cls.newInstance();
            return instance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Object invokeMethod(Object o, Method method, Object... args) {
        Object result;
        method.setAccessible(true);
        try {
            result = method.invoke(o, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void setField(Object o, Field field, Object value) {
        field.setAccessible(true);
        try {
            field.set(o, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
