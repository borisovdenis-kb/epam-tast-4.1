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

    private ArrayList<Field> getSuperFields(Class classObj, ArrayList<Field> fields) {
        Class superClass = classObj.getSuperclass();
        if(superClass != null){
            getSuperFields(superClass, fields);
        }
        Collections.addAll(fields, classObj.getDeclaredFields());
        return fields;
    }

    private ArrayList<Field> getAllFields(Class classObj) {
        ArrayList<Field> allFields = new ArrayList<>();
        Collections.addAll(allFields, classObj.getDeclaredFields());
        allFields.addAll(getSuperFields(classObj, new ArrayList<>()));

        return allFields;
    }

    private ArrayList<Field> filterCacheFields(ArrayList<Field> allFields) {
        allFields
            .stream()
            .filter((f) -> f.getAnnotation(InjectCache.class) != null)
            .forEach((f) -> f.setAccessible(true));

        return allFields;
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
        ArrayList<Field> allFields = getAllFields(classObj);
        ArrayList<Field> cacheFields = filterCacheFields(allFields);

        setCacheToFields(cacheFields, obj);
    }
}
