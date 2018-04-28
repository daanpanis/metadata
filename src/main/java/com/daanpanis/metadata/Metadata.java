package com.daanpanis.metadata;

import org.apache.commons.collections4.map.CaseInsensitiveMap;

public class Metadata {

    private static Metadata empty;

    public static MetadataBuilder builder() {
        return new MetadataBuilder();
    }

    public static Metadata empty() {
        if (empty == null)
            empty = new Metadata(new CaseInsensitiveMap<>(0));
        return empty;
    }

    private final CaseInsensitiveMap<String, Object> values;

    public Metadata(CaseInsensitiveMap<String, Object> values) {
        this.values = values;
    }

    public boolean has(String key) {
        return values.containsKey(key);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) values.get(key);
    }

    public <T> T get(String key, Class<T> castTo) {
        return get(key);
    }

    public boolean is(String key, Object valueToMatch) {
        if (!has(key))
            return false;
        String value = get(key);
        return value.equals(valueToMatch);
    }

    public Class<?> getType(String key) {
        Object value = get(key);
        if (value == null)
            return value.getClass();
        return null;
    }
}
