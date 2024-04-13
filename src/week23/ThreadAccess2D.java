package src.week23;

public class ThreadAccess2D {

    static int[][] data = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
    };

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            int[] arrToAdd = data[0];

            int sum = 0;
            for (int i = 0; i < arrToAdd.length; i++) {
                sum += arrToAdd[i];
            }

            System.out.println(sum);
        });

        Thread t2 = new Thread(() -> {
            int[] arrToAdd = data[1];

            int sum = 0;
            for (int i = 0; i < arrToAdd.length; i++) {
                sum += arrToAdd[i];
            }

            System.out.println(sum);
        });

        Thread t3 = new Thread(() -> {
            int[] arrToAdd = data[2];

            int sum = 0;
            for (int i = 0; i < arrToAdd.length; i++) {
                sum += arrToAdd[i];
            }

            System.out.println(sum);
        });

        try {

            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
