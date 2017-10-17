package ru.intodayer.cacheutility;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


public class CacheCreator {
    private static Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);

        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            dirs.add(new File(url.getFile()));
        }

        List<Class> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(getAllClasses(directory, packageName));
        }
        return classes.toArray(new Class[classes.size()]);
    }

    private static String removeExtension(String s) {
        return s.split("\\.")[0];
    }

    private static List<Class> getAllClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }

        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(
                    getAllClasses(file, packageName + "." + file.getName())
                );
            } else if (file.getName().endsWith(".class")) {
                classes.add(
                    Class.forName(packageName + '.' + removeExtension(file.getName()))
                );
            }
        }
        return classes;
    }

    public static Cache[] createCaches(String packageName)
            throws ClassNotFoundException, IOException, IllegalAccessException,
                   InstantiationException, NoSuchMethodException {
        Class[] cachesClasses = getClasses(packageName);

        List<Cache> caches = new ArrayList<>();
        for (Class classObj: cachesClasses) {
            try {
                Constructor constructor = classObj.getConstructor();
            } catch (NoSuchMethodException e) {
                String message = "Please make cache " + classObj.getName() + " workable with default constructor.";
                throw new NoSuchMethodError(message);
            }
            Cache cache = (Cache) classObj.newInstance();
            DataCreator.fillWithRandomStringData(cache);
            caches.add(cache);
        }
        Cache[] result = new Cache[caches.size()];
        return caches.toArray(result);
    }
}
