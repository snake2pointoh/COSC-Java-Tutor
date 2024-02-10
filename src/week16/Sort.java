package src.week16;

public class Sort {
    public static void main(String[] args) {
        int[] values = {2, 12, 4, 7, 14, 8};
        Integer[] IntValues = {2, 12, 4, 7, 14, 8};

//        InsertSort(values);
//        BubbleSort(values);
//
//        for (int val: values) {
//            System.out.println(val);
//        }

        BubbleGenericSort(IntValues);

        for (Integer val: IntValues) {
            System.out.println(val);
        }

    }

    public static void InsertSort(int[] values) {
        for (int i = 0; i < values.length; i++) {
            int indexSmallest = i;

            for (int j = i + 1; j < values.length; j++) {
                if (values[indexSmallest] > values[j]) {
                    indexSmallest = j;
                }
            }

            // swap
            int temp = values[i];
            values[i] = values[indexSmallest];
            values[indexSmallest] = temp;
        }
    }

    public static <T extends Comparable<T>> void BubbleGenericSort(T[] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - 1; j++) {
                if(values[j].compareTo(values[j + 1]) > 0) {

                    T temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;

                }
            }
        }
    }

    public static void BubbleSort(int[] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = i; j < values.length -1 ; j++) {
                if(values[j] > values[j+1]) {
                    //swap
                    int temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                }
            }
        }
    }
}
