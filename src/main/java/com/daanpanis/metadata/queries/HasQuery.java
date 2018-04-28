package com.daanpanis.metadata.queries;

import com.daanpanis.metadata.Metadata;
import com.daanpanis.metadata.MetadataQuery;

public class HasQuery implements MetadataQuery {

    private final String key;

    public HasQuery(String key) {
        this.key = key;
    }

    @Override
    public boolean matches(Metadata metadata) {
        return metadata.has(key);
    }
}
