package ru.intodayer;


public class App {
    public static void main(String[] args) {
//        MyArrayList list = new MyArrayList();
//        list.put(0, "A");
//        list.put(1, "B");
//        list.put(2, "C");
//        list.put(3, "D");
//
//        System.out.println(list);
//        System.out.println(list.get(2));

        DataStore map = new DataStore();
        map.put(0, "A");
        map.put(1, "B");
        map.put(2, "C");
        map.put(3, "D");
        System.out.println(map);
        System.out.println(map.get(3));
    }
}
