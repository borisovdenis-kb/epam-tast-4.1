package ru.intodayer;

import java.util.HashMap;
import java.util.Map;


public class MyHashMap implements Cache {
    private Map<Integer, String> myMap;

    public MyHashMap() {
        this.myMap = new HashMap<>();
    }

    @Override
    public void put(Integer index, String data) {
        myMap.put(index, data);
    }

    @Override
    public String get(Integer index) {
        return myMap.get(index);
    }

    @Override
    public String toString() {
        return myMap.toString();
    }
}
