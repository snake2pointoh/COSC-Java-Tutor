package src.week5;

public class ModifyArray {
    public static void main(String[] args) {
        int[] array = {1,4,3,2,8,6,7,9,11,10};
        Arrays.printArray(array);

        addOneToArray(array);

        System.out.println("old Array");
        Arrays.printArray(array);

        addOneForEach(array);
        Arrays.printArray(array);

    }

    public static void addOneForEach(int[] arr) {
        for (int item : arr) {
            item++;
        }
    }

    public static void addOneToArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]++;
        }

        System.out.println("New Array");
        Arrays.printArray(arr);
    }
}
