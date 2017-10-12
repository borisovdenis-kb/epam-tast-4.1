package ru.intodayer;

import ru.intodayer.caches.Cache;


public class Fellow {
    @InjectCache(cacheName = "HashMapDataStore") Cache exGirlFriendNames;
    @InjectCache(cacheName = "FragmentedArrayDataStore") Cache myAchievements;
}
