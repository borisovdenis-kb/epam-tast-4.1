package ru.intodayer;

import java.util.ArrayList;


public class MyArrayList implements Cache {
    private ArrayList<String> myArray;

    public MyArrayList() {
        this.myArray = new ArrayList<>(10);
    }

    @Override
    public void put(Integer index, String data) {
        myArray.set(index, data);
    }

    @Override
    public String get(Integer index) {
        return myArray.get(index);
    }

    @Override
    public String toString() {
        return myArray.toString();
    }
}
