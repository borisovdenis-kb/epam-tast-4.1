package ru.intodayer;

import ru.intodayer.caches.Cache;
import ru.intodayer.caches.InjectCache;


public class Fellow extends Man {
    private @InjectCache(cacheName = "HashMapDataStore") Cache exGirlFriendNames;

    public Cache getExGirlFriendNames() {
        return exGirlFriendNames;
    }
}
