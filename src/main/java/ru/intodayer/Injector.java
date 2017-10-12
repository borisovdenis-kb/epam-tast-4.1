package ru.intodayer;

import ru.intodayer.caches.Cache;
import ru.intodayer.caches.CacheDeclaration;
import ru.intodayer.caches.InjectCache;

import java.lang.reflect.Field;
import java.util.*;


public class Injector {
    private Map<String, Cache> knownCaches;

    public Injector(Cache[] caches) {
        knownCaches = initKnownCaches(caches);
    }

    private Map<String, Cache> initKnownCaches(Cache[] caches) {
        ArrayList<Cache> cacheArrayList = new ArrayList<>();
        Collections.addAll(cacheArrayList, caches);

        Map<String, Cache> map = new HashMap<>();
        for (Cache c: cacheArrayList)
            map.put(c.getClass().getAnnotation(CacheDeclaration.class).cacheName(), c);

        return map;
    }

    private ArrayList<Field> getCacheFields(Class classObj) {
        ArrayList<Field> objFields = new ArrayList<>();
        Collections.addAll(objFields, classObj.getDeclaredFields());

        objFields
            .stream()
            .filter((f) -> f.getAnnotation(InjectCache.class) != null)
            .forEach((f) -> f.setAccessible(true));

        return objFields;
    }

    private void setCacheToFields(ArrayList<Field> fields, Object obj) {
        for (Field f: fields) {
            try {
                f.set(obj, knownCaches.get(f.getAnnotation(InjectCache.class).cacheName()));
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void inject(Object obj) {
        Class classObj = obj.getClass();
        ArrayList<Field> cacheFields = getCacheFields(classObj);

        setCacheToFields(cacheFields, obj);
    }
}
