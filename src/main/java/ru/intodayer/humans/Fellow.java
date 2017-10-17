package ru.intodayer.humans;

import ru.intodayer.cacheutility.Cache;
import ru.intodayer.cacheutility.caches.HashMapDataStore;
import ru.intodayer.cacheutility.InjectCache;


public class Fellow extends Man {
    private @InjectCache(cacheName = HashMapDataStore.CACHE_NAME) Cache exGirlFriendNames;

    public Cache getExGirlFriendNames() {
        return exGirlFriendNames;
    }
}
