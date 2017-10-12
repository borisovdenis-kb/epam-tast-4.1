package ru.intodayer.caches;

import ru.intodayer.Cache;


public class FragmentedArrayDataStore implements Cache {
    private String[] dataStore;

    public FragmentedArrayDataStore(int size) {
        this.dataStore = new String[size];
    }

    private void checkRange(Integer index){
        if (index >= dataStore.length - 1 || index < 0)
            throw new IndexOutOfBoundsException();
    }

    @Override
    public void put(Integer index, String data) {
        checkRange(index);
        dataStore[index] = data;
    }

    @Override
    public String get(Integer index) {
        checkRange(index);
        return dataStore[index];
    }

    @Override
    public String toString() {
        return dataStore.toString();
    }
}
