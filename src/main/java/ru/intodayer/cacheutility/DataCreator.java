package ru.intodayer.cacheutility;

import java.util.Random;


public class DataCreator {
    private static final int DATA_AMOUNT = 5;
    private static final int CHARACTER_RANGE = 5;

    private static String getRandomString() {
        Random random = new Random();
        int length = random.nextInt(10);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) random.nextInt(CHARACTER_RANGE);
            sb.append(Character.toString(c));
        }
        return sb.toString();
    }

    public static void fillWithRandomStringData(Cache cache) {
        for (int i = 0; i < DATA_AMOUNT; i++) {
            cache.put(i, getRandomString());
        }
    }
}
