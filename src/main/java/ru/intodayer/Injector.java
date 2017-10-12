package ru.intodayer;

import ru.intodayer.caches.Cache;
import java.lang.reflect.Field;
import java.util.*;


public class Injector {
    private ArrayList<Cache> caches;
    private Map<String, Cache> cacheMap = new HashMap<>();

    public Injector(Cache[] caches) {
        Collections.addAll(this.caches, caches);
        initHashMap();
    }

    private void initHashMap() {
        caches
            .stream().forEach((c) -> {
                cacheMap.put(c.getClass().getAnnotation(InjectCache.class).cacheName(), c);
        });
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
        fields
            .stream().forEach((f) -> {
                try {
                    f.set(obj, cacheMap.get(f.getAnnotation(InjectCache.class).cacheName()));
                } catch (IllegalAccessException e) {
                    System.out.println(e.getMessage());
                }
        });
    }

    public void inject(Object obj) {
        Class classObj = obj.getClass();
        ArrayList<Field> cacheFields = getCacheFields(classObj);

        setCacheToFields(cacheFields, obj);
    }
}
