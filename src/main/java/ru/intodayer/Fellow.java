package ru.intodayer;

import ru.intodayer.caches.Cache;
import ru.intodayer.caches.InjectCache;


public class Fellow {
    @InjectCache(cacheName = "HashMapDataStore") Cache exGirlFriendNames;
    @InjectCache(cacheName = "FragmentedArrayDataStore") Cache myAchievements;
}
