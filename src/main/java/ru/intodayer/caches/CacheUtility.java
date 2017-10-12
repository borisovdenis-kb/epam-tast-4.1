package ru.intodayer.caches;


public class CacheUtility {
    public static Cache[] createCaches() {
        Cache hashTableDS = new HashTableDataStore();
        hashTableDS.put(0, "Ева Грин");
        hashTableDS.put(1, "Эмма Стоун");
        hashTableDS.put(2, "Галь Гадот");

        Cache fragmentArray = new FragmentedArrayDataStore(3);
        fragmentArray.put(0, "Кубок региона по жанглированию.");
        fragmentArray.put(1, "Победа в реп баттле.");
        fragmentArray.put(2, "Заплыв до того берега Волги и обратно.");

        return new Cache[]{hashTableDS, fragmentArray};
    }
}
