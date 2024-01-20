package src.week13;

public class Generics {
    public static void main(String[] args) {

        Integer[] myArray = {2,4,14,1,12,7};

        for (Integer item : myArray ) {
            System.out.println(item);
        }

        sort2(myArray);

        System.out.println("\n");

        for (Integer item : myArray ) {
            System.out.println(item);
        }

    }

    // select sort
    public static <T extends Comparable<T>> void sort(T[] array) {
        for(int i = 0; i < array.length; i++) {
            int indexOfSmallest = i;

            for (int j = i + 1; j < array.length; j++) {
                // compare current smallest
                // if next is smaller than mark as smallest
                if(array[j].compareTo(array[indexOfSmallest]) < 0) {
                    indexOfSmallest = j;
                }
            }
            // swap i with the smallest

            T temp = array[i];
            array[i] = array[indexOfSmallest];
            array[indexOfSmallest] = temp;
        }
    }

    public static void sort2(Comparable[] array) {
        for(int i = 0; i < array.length; i++) {
            int indexOfSmallest = i;

            for (int j = i + 1; j < array.length; j++) {
                // compare current smallest
                // if next is smaller than mark as smallest
                if(array[j].compareTo(array[indexOfSmallest]) < 0) {
                    indexOfSmallest = j;
                }
            }
            // swap i with the smallest

            Comparable temp = array[i];
            array[i] = array[indexOfSmallest];
            array[indexOfSmallest] = temp;
        }
    }
}
