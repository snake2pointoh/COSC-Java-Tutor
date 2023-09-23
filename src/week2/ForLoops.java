package src.week2;

public class ForLoops {
    public static void main(String[] args) {
        for(int i = 0; i<10; i++) {
//            System.out.println(i);
        }

        int counter = 0;
        while(counter < 10) {
            counter++;
        }
//        System.out.println(counter);

        for (int i=0, j=0; i<10; i++) {
//            System.out.println(i);

            if(i%2==0){
                j++;
            }
        }

        for (int i = 0; i<256 ;i++) {
            char printChar = (char)i;
            System.out.println(printChar);
        }

    }
}
