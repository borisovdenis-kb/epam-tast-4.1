package ru.intodayer.humans;

import ru.intodayer.caches.Cache;
import ru.intodayer.caches.InjectCache;


public class Man  extends Human {
    private @InjectCache(cacheName = "FragmentedArrayDataStore") Cache achievements;

    public Cache getAchievements() {
        return achievements;
    }
}
