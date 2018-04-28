package com.daanpanis.metadata;

import org.apache.commons.collections4.map.CaseInsensitiveMap;

public class MetadataBuilder {

    private final CaseInsensitiveMap<String, Object> metaValues = new CaseInsensitiveMap<>();

    protected MetadataBuilder() {
    }

    public MetadataBuilder value(String key, Object value) {
        this.metaValues.put(key, value);
        return this;
    }

    public Metadata build() {
        return new Metadata(metaValues);
    }
}