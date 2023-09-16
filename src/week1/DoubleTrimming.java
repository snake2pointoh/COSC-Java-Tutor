package src.week1;

public class DoubleTrimming {
    public static void main(String[] args) {
        double dNum = 2.5555;

        // make the double equal 2.55

        // change dnum = 255.55
        int nDecimalPrecision = 100;

        dNum *= nDecimalPrecision; // dNum = (dNum * 100);
        System.out.println(dNum);

        int nVal = (int) dNum; // 255
        System.out.printf("Double: %f, Int %d\n", dNum, nVal);

        double dNewNum = nVal; // 255.0
        System.out.println(dNewNum);

        dNewNum /= nDecimalPrecision;

        System.out.println(dNewNum);

        System.out.printf("my double is: %.2f\n", 2.5555);
        System.out.printf("my new double is: %.2f\n", dNewNum);



    }
}
