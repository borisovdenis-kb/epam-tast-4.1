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
        List<Cache> cacheList = new ArrayList<>();
        Collections.addAll(cacheList, caches);

        Map<String, Cache> map = new HashMap<>();
        for (Cache c: cacheList)
            map.put(c.getClass().getAnnotation(CacheDeclaration.class).cacheName(), c);

        return map;
    }

    private List<Field> getAllFields(Class classObj) {
        List<Field> allFields = new ArrayList<>();
        Collections.addAll(allFields, classObj.getDeclaredFields());

        Class superClass = classObj.getSuperclass();
        while (superClass != Object.class) {
            Collections.addAll(allFields, superClass.getDeclaredFields());
            superClass = superClass.getSuperclass();
        }
        return allFields;
    }

    private List<Field> filterCacheFields(List<Field> allFields) {
        allFields
            .stream()
            .filter((f) -> f.getAnnotation(InjectCache.class) != null)
            .forEach((f) -> f.setAccessible(true));

        return allFields;
    }

    private void setCacheToFields(List<Field> fields, Object obj) throws IllegalAccessException {
        for (Field f: fields) {
            f.set(obj, knownCaches.get(f.getAnnotation(InjectCache.class).cacheName()));
        }
    }

    public void inject(Object obj) throws IllegalAccessException {
        Class classObj = obj.getClass();
        List<Field> allFields = getAllFields(classObj);
        List<Field> injectableFields = filterCacheFields(allFields);

        setCacheToFields(injectableFields, obj);
    }
}
