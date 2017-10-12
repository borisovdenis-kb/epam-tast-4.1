package ru.intodayer;

import ru.intodayer.caches.Cache;
import ru.intodayer.caches.CacheUtility;


public class App {
    public static void main(String[] args) {
        for (Cache c: CacheUtility.createCache()) {
            System.out.println(c);
        }
    }
}
