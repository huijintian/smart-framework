package org.smart.annotation;

import java.lang.annotation.*;

/**
 * Created by mengtian on 2017/11/23
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
