package src.week5;

import java.awt.*;

public class Arrays {
    public static void main(String[] args) {
        int[] array = {1,4,6,2,4,5,8,7,9,1}; // array of size 10
        printArray(array);

//        int[] ar2 = array;
        int[] ar2 = copyArray(array);
        printArray(ar2);

        ar2[0] = 10;
        printArray(ar2);
        printArray(array);
    }

    public static int[] copyArray(int[] oldArr) {
        int[] newArr = new int[oldArr.length];

        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = oldArr[i];
        }

        return newArr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println( arr[i] );
        }
        System.out.println();
    }
}
