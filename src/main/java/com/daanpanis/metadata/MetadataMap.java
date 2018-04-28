package com.daanpanis.metadata;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MetadataMap<T, V> implements Map<T, V> {

    private final Map<T, MetadataEntry<V>> map = new HashMap<>();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return map.get(key).value;
    }

    @Override
    public V put(T key, V value) {
        return put(key, value, Metadata.empty());
    }

    public V put(T key, V value, Function<MetadataBuilder, MetadataBuilder> builderFunction) {
        return put(key, value, builderFunction.apply(Metadata.builder()).build());
    }

    public V put(T key, V value, Metadata metadata) {
        MetadataEntry<V> result = map.put(key, new MetadataEntry<>(metadata, value));
        return result != null ? result.value : null;
    }

    @Override
    public V remove(Object key) {
        MetadataEntry<V> result = map.remove(key);
        return result != null ? result.value : null;
    }

    @Override
    public void putAll(Map<? extends T, ? extends V> m) {
        map.putAll(m.entrySet().stream()
                .collect(Collectors.toMap(Entry::getKey, entry -> new MetadataEntry<>(Metadata.empty(), entry.getValue()))));
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<T> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        return map.values().stream().map(entry -> entry.value).collect(Collectors.toList());
    }

    @Override
    public Set<Entry<T, V>> entrySet() {
        return map.entrySet().stream().collect(Collectors.toMap(Entry::getKey, entry -> entry.getValue().value)).entrySet();
    }

    private class MetadataEntry<K> {

        private final Metadata metadata;
        private final K value;

        public MetadataEntry(Metadata metadata, K value) {
            this.metadata = metadata;
            this.value = value;
        }
    }
}
