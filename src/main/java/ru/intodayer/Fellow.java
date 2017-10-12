package ru.intodayer;

import ru.intodayer.caches.Cache;
import ru.intodayer.caches.InjectCache;


public class Fellow {
    private @InjectCache(cacheName = "HashMapDataStore") Cache exGirlFriendNames;
    private @InjectCache(cacheName = "FragmentedArrayDataStore") Cache achievements;

    public Cache getExGirlFriendNames() {
        return exGirlFriendNames;
    }

    public Cache getAchievements() {
        return achievements;
    }
}
