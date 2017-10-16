package ru.intodayer;

import ru.intodayer.caches.Cache;
import ru.intodayer.caches.CacheUtility;
import ru.intodayer.humans.Fellow;


public class InjectorWorkDemonstration {
    public static void demonstrateInjectorWork() {
        Fellow fellow = new Fellow();
        Cache[] caches = CacheUtility.createCaches();
        Injector injector = new Injector(caches);

        injector.inject(fellow);

        System.out.println(
                "Fellow`s ex-girlfriends:\n" + fellow.getExGirlFriendNames() + "\n"
        );
        System.out.println(
                "Fellow`s achievements <private field from SUPER>:\n" + fellow.getAchievements() + "\n"
        );
        System.out.println(
                "Fellow`s brilliant ideas <private field from SUPER.SUPER>:\n" + fellow.getBrilliantIdeas() + "\n"
        );
    }
}
