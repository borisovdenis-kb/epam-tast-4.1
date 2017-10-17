package ru.intodayer.humans;

import ru.intodayer.cacheutility.Cache;
import ru.intodayer.cacheutility.caches.FragmentedArrayDataStore;
import ru.intodayer.cacheutility.InjectCache;


public class Man  extends Human {
    private @InjectCache(cacheName = FragmentedArrayDataStore.cacheName) Cache achievements;

    public Cache getAchievements() {
        return achievements;
    }
}
