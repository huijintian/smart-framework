package org.smart.proxy;

/**
 * Created by mengtian on 2017/11/23
 */
public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
