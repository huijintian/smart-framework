package org.smart.proxy;

import java.lang.reflect.Method;

/**
 * Created by mengtian on 2017/11/23
 */
public abstract class AspectProxy implements Proxy {
    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;

        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();
        begin();

        if (intercept(cls, method, params)) {
            before(cls, method, params);
            result = proxyChain.doProxyChain();
            after(cls, method, params, result);
        } else {
            result = proxyChain.doProxyChain();
        }
        end();

        return result;
    }

    public void after(Class<?> cls, Method method, Object[] params, Object result) {

    }

    public void before(Class<?> cls, Method method, Object[] params) {

    }

    public boolean intercept(Class<?> cls, Method method, Object[] params) {
        return true;
    }

    public void begin() {
    }

    public void end() {
    }
}
