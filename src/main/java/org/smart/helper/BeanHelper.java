package org.smart.helper;

import org.smart.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by mengtian on 2017/11/22
 */
public final class BeanHelper {

    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClass();
        for (Class<?> beanClass : beanClassSet) {
            Object bean = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, bean);
        }
    }

    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    public static <T> T getBean(Class<T> cls) {
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("can not get bean class");
        }
        return (T) BEAN_MAP.get(cls);
    }

    public static void setBean(Class<?> cls, Object object) {
        BEAN_MAP.put(cls, object);
    }
}
