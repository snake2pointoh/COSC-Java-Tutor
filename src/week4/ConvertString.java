package src.week4;

public class ConvertString {
    public static void main(String[] args) {
        //convert to int with the Integer Class
        int myNumbers = Integer.parseInt("12345");
        System.out.println(myNumbers);

        //convert to int manually
        int convertedNumber = stringToInt("13257");
        System.out.println(convertedNumber);

        //convert number to binary
        int myNum = 27; // should be 00011011
        System.out.println(convertToBinary(myNum));
    }

    public static int stringToInt(String sVal) {
        int myNumber = 0;

        // 13257 - length 5
        for (int i = 0; i < sVal.length(); i++) {
            char currentChar = sVal.charAt(i);

            // check if the character is a number character between '0' and '9'
            if(currentChar >= '0' && currentChar <= '9')
            {
                int charToNumber = currentChar - '0';
                myNumber += charToNumber;
                myNumber = myNumber * 10;
            }
        }

        myNumber = myNumber / 10;

        return myNumber;
    }

    //13247e

//    public static String convertToHex() {
//
//    }


    /**
     * this method will convert a number to an 8Bit binary value
     * @param number the number to convert
     * @return an 8Bit binary value
     */
    public static String convertToBinary(int number)
    {
        // keep track of the binary number
        String binaryNumber = "";

        // keep track of the current binary values power 128 = 2^7
        int currentBitPower = 7;

        while(currentBitPower >= 0) {

            int currentBitValue = (int) Math.pow(2, currentBitPower); // 128, 64, 32, ...

            // if the current binary value goes into our number then...
            if (number / currentBitValue > 0) {
                // add 1 to the binary number
                binaryNumber += '1';
                // remove the current binary value from our number
                number = number % currentBitValue;
            } else {
                // if not add 0 to the binary number
                binaryNumber += '0';
            }

            // look at the next binary power
            currentBitPower--;
        }

        return binaryNumber;
    }
}
