package org.smart.helper;

import org.smart.annotation.Controller;
import org.smart.annotation.Service;
import org.smart.util.ClassUtil;
import org.smart.util.PropsUtil;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * Created by mengtian on 2017/11/22
 */
public final class ClassHelper {
    private static final Set<Class<?>> CLASS_SET;

    static {
        Properties properties = PropsUtil.loadProps("baseConfig");
        String basePackage = PropsUtil.getString(properties, "basePackage");
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    public static Set<Class<?>> getClazzSet() {
        return CLASS_SET;
    }

    public static Set<Class<?>> getServiceClass() {
        return getTypeClass(Service.class);
    }

    public static Set<Class<?>> getControllerClass() {
        return getTypeClass(Controller.class);
    }

    public static Set<Class<?>> getBeanClass() {
        Set<Class<?>> classSet = new HashSet<>();
        classSet.addAll(getServiceClass());
        classSet.addAll(getControllerClass());
        return classSet;
    }

    private static Set<Class<?>> getTypeClass(Class type) {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(type)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }
}
