package com.daanpanis.metadata;

import java.util.function.Function;

public interface MetadataQuery {

    boolean matches(Metadata metadata);

    default MetadataQuery and(Function<MatcherBuilder, MetadataQuery> query) {
        return metadata -> matches(metadata) && query.apply(new MatcherBuilder()).matches(metadata);
    }

    default MetadataQuery or(Function<MatcherBuilder, MetadataQuery> query) {
        return metadata -> matches(metadata) || query.apply(new MatcherBuilder()).matches(metadata);
    }

}
