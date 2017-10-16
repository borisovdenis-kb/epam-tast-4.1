package ru.intodayer.humans;

import ru.intodayer.caches.Cache;
import ru.intodayer.caches.HashMapDataStore;
import ru.intodayer.caches.InjectCache;


public class Fellow extends Man {
    private @InjectCache(cacheName = HashMapDataStore.cacheName) Cache exGirlFriendNames;

    public Cache getExGirlFriendNames() {
        return exGirlFriendNames;
    }
}
