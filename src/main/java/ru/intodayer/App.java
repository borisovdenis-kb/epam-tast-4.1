package ru.intodayer;

import ru.intodayer.caches.Cache;
import ru.intodayer.caches.CacheUtills;


public class App {
    public static void main(String[] args) {
        for (Cache c: CacheUtills.createCache()) {
            System.out.println(c);
        }
    }
}
