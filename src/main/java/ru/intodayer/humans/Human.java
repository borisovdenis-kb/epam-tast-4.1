package ru.intodayer.humans;

import ru.intodayer.cacheutility.Cache;
import ru.intodayer.cacheutility.caches.HashMapDataStore;
import ru.intodayer.cacheutility.InjectCache;


public class Human {
    private @InjectCache(cacheName = HashMapDataStore.CACHE_NAME) Cache brilliantIdeas;

    public Cache getBrilliantIdeas() {
        return brilliantIdeas;
    }
}
