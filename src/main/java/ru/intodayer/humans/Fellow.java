package ru.intodayer.humans;

import ru.intodayer.cacheutility.Cache;
import ru.intodayer.cacheutility.HashMapDataStore;
import ru.intodayer.cacheutility.InjectCache;


public class Fellow extends Man {
    private @InjectCache(cacheName = HashMapDataStore.cacheName) Cache exGirlFriendNames;

    public Cache getExGirlFriendNames() {
        return exGirlFriendNames;
    }
}
