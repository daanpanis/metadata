package com.daanpanis.metadata.queries;

import com.daanpanis.metadata.Metadata;
import com.daanpanis.metadata.MetadataQuery;

public class TypeOfQuery<T> implements MetadataQuery {

    private final String key;
    private final Class<T> type;

    public TypeOfQuery(String key, Class<T> type) {
        this.key = key;
        this.type = type;
    }

    @Override
    public boolean matches(Metadata metadata) {
        Class<?> typeOfValue = metadata.getType(key);
        return typeOfValue != null && type.isAssignableFrom(typeOfValue);
    }
}
