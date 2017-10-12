package ru.intodayer.caches;


@CacheDeclaration(cacheName = "FragmentedArrayDataStore")
public class FragmentedArrayDataStore implements Cache {
    private String[] dataStore;

    public FragmentedArrayDataStore(int size) {
        this.dataStore = new String[size];
    }

    private void checkRange(Integer index){
        if (index >= dataStore.length || index < 0)
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
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < dataStore.length-1; i++) {
            sb.append(dataStore[i]);
            sb.append(", ");
        }
        sb.append(dataStore[dataStore.length-1]);
        sb.append("]");
        return sb.toString();
    }
}
