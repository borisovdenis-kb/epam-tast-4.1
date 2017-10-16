package ru.intodayer.humans;

import ru.intodayer.caches.Cache;
import ru.intodayer.caches.HashMapDataStore;
import ru.intodayer.caches.InjectCache;


public class Human {
    private @InjectCache(cacheName = HashMapDataStore.cacheName) Cache brilliantIdeas;

    public Cache getBrilliantIdeas() {
        return brilliantIdeas;
    }
}
