package src.week2;

public class WhileLoop {
    public static void main(String[] args) {
        // simple while loop that  counts to 10
        int counter = 0;
        while(counter < 10) {
            counter++;
        }
        System.out.println(counter);

        // while loop with continue
        counter = 0;
        int sum = 0;
        while (counter < 100) {
            counter++;
            if(counter % 2 == 0) {
                continue;
            }
            sum += counter;
        }

        System.out.println(counter);
        System.out.println(sum);


        // while loop with break
        counter = 0;
        sum = 0;
        while (counter < 100) {
            counter++;
            if(sum > 100) {
                break;
            }
            sum += counter;
        }

        System.out.println(counter);
        System.out.println(sum);
    }
}
