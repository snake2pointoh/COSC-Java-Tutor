package src.week6;

public class Arrays {
    public static void main(String[] args) {
        int[] testArr = {10,2,8,5,4,12,7,14};
        // ascending    : 2,4,5,7,8,10,12,14
        // descending   : 14,12,10,8,7,5,4,2


//        selectionSort(testArr);
//        selectionSortDesc(testArr);
//        bubbleSort(testArr);
        bubbleSortDesc(testArr);

        int indexFound = binarySearch(testArr, 5);
        int indexNotFound = binarySearch(testArr, 13);

        for (int i = 0; i < testArr.length; i++) {
            System.out.println(testArr[i]);
        }

        System.out.println("\n"+indexFound);
        System.out.println("\n"+indexNotFound);
    }

    // sort arrays
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // keep track of the location of the smallest element
            int indexOfSmallest = i;
            for (int j = i+1; j < array.length; j++) {
                // if the current smallest is bigger than the one we are looking at then set
                // the smallest to be one we are looking at
                if(array[indexOfSmallest] > array[j]){
                    indexOfSmallest = j;
                }
            }
            swapElements(i,indexOfSmallest,array);
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean didSwap = false;

            for (int j = 0; j < array.length - 1; j++) {
                // if the current is bigger than the nex then swap them
                if(array[j] > array[j+1]) {
                    swapElements(j, j+1 , array);
                    didSwap = true;
                }
            }

            if (!didSwap) {
                return;
            }
        }
    }

    public static void selectionSortDesc(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // keep track of the location of the smallest element
            int indexOfLargest = i;
            for (int j = i+1; j < array.length; j++) {
                // if the current smallest is bigger than the one we are looking at then set
                // the smallest to be one we are looking at
                if(array[indexOfLargest] < array[j]){
                    indexOfLargest = j;
                }
            }
            swapElements(i,indexOfLargest,array);
        }
    }

    public static void bubbleSortDesc(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean didSwap = false;

            for (int j = 0; j < array.length - 1; j++) {
                // if the current is smaller than the next then swap them
                if(array[j] < array[j+1]) {
                    swapElements(j, j+1 , array);
                    didSwap = true;
                }
            }

            if (!didSwap) {
                return;
            }
        }
    }

    public static void swapElements(int a, int b, int[] array) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    // search arrays
    // return the index of the element found
    public static int binarySearch(int[] array, int search) {
        int low = 0;
        int high = array.length-1;

        while (high >= low) {
            int mid = (low+high)/2;

            if(array[mid] == search) {
                return mid;
            }
            if(array[mid] < search) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

}
