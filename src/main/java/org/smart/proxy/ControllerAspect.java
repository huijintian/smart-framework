package org.smart.proxy;

import org.smart.annotation.Aspect;
import org.smart.annotation.Controller;

import java.lang.reflect.Method;

/**
 * Created by mengtian on 2017/11/23
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) {
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) {
        System.out.println(System.currentTimeMillis() - begin);
    }
}
