package src.week6;

public class Arrays2D {
    public static void main(String[] args) {
        int[][] Arr2d = {
                {1,3,4},
                {2,5,5},
                {6,3,8} };

        int[][] Arr2dEmpt = new int[3][3];
        // 0,0,0
        // 0,0,0
        // 0,0,0

        int[][] arr2dGen = new int[4][0];
        int[] row1 = new int[3];
        int[] row2 = new int[7];
        int[] row3 = new int[6];
        int[] row4 = new int[2];

        arr2dGen[0] = row1;
        arr2dGen[1] = row2;
        arr2dGen[2] = row3;
        arr2dGen[3] = row4;

        System.out.println(Arr2d[1][1]);
    }
}
