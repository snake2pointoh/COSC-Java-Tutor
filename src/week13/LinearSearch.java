package src.week13;

public class LinearSearch {
    public static void main(String[] args) {
        int[] myArray = {1, 3, 5, 5, 7, 12, 14, 18};

        System.out.println(linearSearch(myArray, 7)); // 4

        System.out.println(recLinearSearch(myArray, 0, 7)); // 4

    }

    public static int linearSearch(int[] array, int item) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == item) {
                return i;
            }
        }

        return -1;
    }

    public static int recLinearSearch(int[] array, int index, int item) {
        // index is out of range
        if(index >= array.length) {
            return -1;
        }
        // found the item
        if(array[index] == item) {
            return index;
        }

        // index++

        return recLinearSearch(array, ++index, item);
    }
}
