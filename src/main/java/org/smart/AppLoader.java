package org.smart;

import org.smart.helper.*;
import org.smart.util.ClassUtil;

/**
 * Created by mengtian on 2017/11/22
 */
public final class AppLoader {
    public static void init() {
        Class<?>[] classes = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class};

        for (Class<?> cls : classes) {
            ClassUtil.loadClass(cls.getName(), false);
        }
    }
}
