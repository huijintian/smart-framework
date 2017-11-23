package org.smart.bean;

import java.util.Map;

/**
 * Created by mengtian on 2017/11/22
 * <p>
 * 请求参数对象
 */
public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public long getLong(String name) {
        return (long) paramMap.get(name);
    }

    public Map<String, Object> getMap() {
        return paramMap;
    }
}
