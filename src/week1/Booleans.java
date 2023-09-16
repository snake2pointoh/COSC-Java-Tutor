package src.week1;

public class Booleans {
    public static void main(String[] args) {
        boolean isTrue = true;
        boolean isFalse = false;

        if(true) { // true
            System.out.println("my boolean is true!");
        }

        if(false) {
            System.out.println("my boolean is true!");
        }

        if(12 == 12) {
            System.out.println("12 is 12!");
        }

        if(12 != 10) {
            System.out.println("12 is not 10!");
        }

        if(false == isFalse)
        {
            System.out.println("false is false");
        }

//        >, <, ==, !=, &&, or ||, exclusive or ^,
        if(isTrue || true){
            System.out.println("one or more is true");
        }

        if(true ^ true) {
            System.out.println("ONLY one is true");
        }

        if(true && isTrue) {
            System.out.println("both are true");
        }

        if(5 > 4){
            System.out.println("5 is bigger");
            if(4 > 3) {
                System.out.println("4 is also big");
            }
//            System.out.println("done checking");
        }

        if(5 < 6){
            System.out.println("5 is smaller");
        }

        boolean bVal = 1>2;// bVal = false
        if(1>2) {
            bVal = true;
        } else {
            bVal = false;
        }

        int myNum = (true)? 5 : 1;

        if(true) {
            myNum = 5;
        } else {
            myNum = 1;
        }
        System.out.println(myNum);

    }
}
