package org.smart.helper;

import org.apache.commons.lang3.ArrayUtils;
import org.smart.annotation.Inject;
import org.smart.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by mengtian on 2017/11/22
 */
public final class IocHelper {
    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
            Class<?> beanClass = beanEntry.getKey();
            Object beanInstance = beanEntry.getValue();

            Field[] fields = beanClass.getDeclaredFields();
            if (ArrayUtils.isNotEmpty(fields)) {
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Inject.class)) {
                        Class<?> fieldClass = field.getType();
                        Object fieldInstance = beanMap.get(fieldClass);
                        if (fieldInstance != null) {
                            ReflectionUtil.setField(beanInstance, field, fieldInstance);
                        }
                    }
                }
            }
        }
    }
}
