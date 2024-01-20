package src.week13;

public class MyArrayList <T extends Comparable<T>> {
    T[] values;

    MyArrayList(T[] array) {
        values = array;
    }

//    MyArrayList() {
//        values = new T[10];
//    }

    public T getAt(int index) {
        return values[index];
    }

}