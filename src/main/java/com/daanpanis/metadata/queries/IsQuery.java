package com.daanpanis.metadata.queries;

import com.daanpanis.metadata.Metadata;
import com.daanpanis.metadata.MetadataQuery;

public class IsQuery implements MetadataQuery {

    private final String key;
    private final Object value;

    public IsQuery(String key, Object value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public boolean matches(Metadata metadata) {
        return metadata.is(key, value);
    }
}
