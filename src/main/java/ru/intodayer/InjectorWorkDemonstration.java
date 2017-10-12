package ru.intodayer;


import ru.intodayer.caches.Cache;
import ru.intodayer.caches.CacheUtility;

public class InjectorWorkDemonstration {
    public static void demonstrateInjectorWork() {
        Fellow fellow       = new Fellow();
        Cache[] caches      = CacheUtility.createCaches();
        Injector injector   = new Injector(caches);

        injector.inject(fellow);

        System.out.println("Fellow`s ex-girlfriends: " + fellow.getExGirlFriendNames());
        System.out.println("Fellow`s achievements: " + fellow.getAchievements());
    }
}
