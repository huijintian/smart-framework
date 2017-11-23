package org.smart.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengtian on 2017/11/22
 * <p>
 * 返回的视图对象
 */
public class View {
    private String path;
    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        model = new HashMap<>();
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
