package src.week6;

import java.util.Scanner;

public class FromInput2D {
    public static void main(String[] args) {
        Scanner obIn = new Scanner(System.in);

        // read in the whole line
        // split on spaces
        // assign to an array

        int numberOrRows = 0;
        String[][] inputArray = new String[0][0];
        while(true) {
            String line = obIn.nextLine();

            if(line.trim().length() <= 0) {
                break;
            }

            // grow the array
            inputArray = growArray(inputArray);

            // inset the new row
            inputArray[numberOrRows] = line.split(" ");

            numberOrRows++;
        }

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                System.out.printf(inputArray[i][j]+ " ");
            }
            System.out.println();
        }
    }


    public static String[][] growArray(String[][] array){
        String[][] newArray = new String[array.length+1][0];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                newArray[i][j] = array[i][j];
            }
        }

        return newArray;
    }
}
