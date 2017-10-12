package ru.intodayer;

import ru.intodayer.caches.Cache;
import ru.intodayer.caches.InjectCache;


public class Human {
    private @InjectCache(cacheName = "HashMapDataStore") Cache brilliantIdeas;

    public Cache getBrilliantIdeas() {
        return brilliantIdeas;
    }
}
