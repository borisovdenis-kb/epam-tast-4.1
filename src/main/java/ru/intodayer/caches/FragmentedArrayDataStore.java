package ru.intodayer.caches;


@CacheDeclaration(cacheName = "FragmentedArrayDataStore")
public class FragmentedArrayDataStore implements Cache {
    private String[] dataStore;

    public FragmentedArrayDataStore(int size) {
        this.dataStore = new String[size];
    }

    @Override
    public void put(Integer index, String data) {
        dataStore[index] = data;
    }

    @Override
    public String get(Integer index) {
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
