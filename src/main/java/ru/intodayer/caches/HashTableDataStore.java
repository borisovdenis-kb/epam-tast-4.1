package ru.intodayer.caches;

import ru.intodayer.CacheDeclaration;
import java.util.HashMap;
import java.util.Map;


@CacheDeclaration(cacheName = "HashTableDataStore")
public class HashTableDataStore implements Cache {
    private Map<Integer, String> dataStore;

    public HashTableDataStore() {
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
