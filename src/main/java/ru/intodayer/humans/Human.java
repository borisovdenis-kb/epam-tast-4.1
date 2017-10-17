package ru.intodayer.humans;

import ru.intodayer.cacheutility.Cache;
import ru.intodayer.cacheutility.HashMapDataStore;
import ru.intodayer.cacheutility.InjectCache;


public class Human {
    private @InjectCache(cacheName = HashMapDataStore.cacheName) Cache brilliantIdeas;

    public Cache getBrilliantIdeas() {
        return brilliantIdeas;
    }
}
