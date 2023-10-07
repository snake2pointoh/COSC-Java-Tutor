package src.week2;

import java.util.Scanner;

public class PrintPyramid {
    public static void main(String[] args) {
        // prompt the user for a number of lines of the pyramid
        // print out a pyramid
        // EX: 3
//               3
//              232
//             12321
        Scanner obIn = new Scanner(System.in);
        System.out.println("enter a number of levels");
        int levels = obIn.nextInt();

        // for the first level print out    __3__
        // for the second level print out   _232_
        // for the third level print out    12321
         printPyramid(levels);
        printPyramid(levels + 2);

    }

    public static void printPyramid(int levels)
    {
        for (int i = levels; i> 0; i--){ // 3 time or the number of levels
            String levelString = ""; // placeholder for storing the levels string __3__
            //left side of the pyramid

            // for each position on a level
            // check if the number is the same as or greater than the levelNumber
            //      than put that number onto the level
            //      if not put a space onto the level

            // if the level is 3 make the level string __3
            for (int j = 1; j <= levels; j++) { // smallest character on a level is one so start at one
                if (j >= i) { // if j is the same as the smallest character for that level then add it to the level string
                    levelString += j;
                } else { // if not add a space for formatting
                    levelString += ' ';
                }
            }
            // right side of the pyramid

            // the level is 3 make the level string __
            // because we already have the center value of 3, skip it and go to the next
            // in i =1 previous loop outputs 123

            for (int j = levels-1; j > 0; j--) {
                if(i > j) {
                    levelString += ' ';
                } else {
                    levelString += j;
                }
            }
//            __3__


            System.out.println(levelString);
        }
    }
}
