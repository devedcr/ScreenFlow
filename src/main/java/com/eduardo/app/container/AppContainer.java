package com.eduardo.app.container;

import java.util.HashMap;
import java.util.Map;

public class AppContainer {
    private static final Map<String, Object> container = new HashMap<>();

    public static void put(String key, Object value) {
        container.put(key, value);
    }

    public static <T> T get(String key, Class<T> type) {
        if (container.containsKey(key)) return type.cast(container.get(key));
        throw new RuntimeException("No Found Object " + key + " in the container !!!");
    }
}