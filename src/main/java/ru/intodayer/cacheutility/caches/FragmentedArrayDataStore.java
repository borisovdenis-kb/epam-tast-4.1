package ru.intodayer.cacheutility.caches;

import ru.intodayer.cacheutility.Cache;
import ru.intodayer.cacheutility.CacheDeclaration;


@CacheDeclaration(cacheName = FragmentedArrayDataStore.CACHE_NAME)
public class FragmentedArrayDataStore implements Cache {
    public static final String CACHE_NAME = "FragmentedArrayDataStore";
    private final int size = 10;
    private String[] dataStore = new String[size];

    @Override
    public void put(Integer index, String data) {
        dataStore[index] = data;
    }

    @Override
    public String get(Integer index) {
        return dataStore[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < dataStore.length-1; i++) {
            sb.append(dataStore[i]);
            sb.append(", ");
        }
        sb.append(dataStore[dataStore.length-1]);
        sb.append("]");
        return sb.toString();
    }
}
