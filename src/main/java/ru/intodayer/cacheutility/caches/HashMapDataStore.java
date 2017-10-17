package ru.intodayer.cacheutility.caches;

import ru.intodayer.cacheutility.Cache;
import ru.intodayer.cacheutility.CacheDeclaration;

import java.util.HashMap;
import java.util.Map;


@CacheDeclaration(cacheName = HashMapDataStore.cacheName)
public class HashMapDataStore implements Cache {
    public static final String cacheName = "HashMapDataStore";
    private Map<Integer, String> dataStore;

    public HashMapDataStore() {
        this.dataStore = new HashMap<>();
    }

    @Override
    public void put(Integer index, String data) {
        dataStore.put(index, data);
    }

    @Override
    public String get(Integer index) {
        return dataStore.get(index);
    }

    @Override
    public String toString() {
        return dataStore.toString();
    }
}
