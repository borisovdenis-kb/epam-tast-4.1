package ru.intodayer.cacheutility;


public interface Cache {
    void put(Integer index, String data);
    String get(Integer index);
}
