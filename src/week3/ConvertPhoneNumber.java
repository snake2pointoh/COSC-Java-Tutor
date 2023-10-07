package src.week3;

public class ConvertPhoneNumber {
    public static void main(String[] args) {
        String phoneNumber = "1800Flowers";
        System.out.printf("%s in number is %s\n", phoneNumber, convertPhoneNumber(phoneNumber));
    }

    //EXAMPLE:
    // INPUT: 1800Flowers
    // OUTPUT: 18003569377

    public static String convertPhoneNumber(String phoneNumber)
    {
        phoneNumber = phoneNumber.toLowerCase();

        String convertedPhone = "";
        // if a,b,c 2, d,e,f = 3
        for (int i = 0; i < phoneNumber.length(); i++)
        {
            char currentChar = phoneNumber.charAt(i);
            if( currentChar == 'a' || currentChar == 'b' || currentChar == 'c')
            {
                convertedPhone += "2";
                continue;
            }
            if( currentChar == 'd' || currentChar == 'e' || currentChar == 'f')
            {
                convertedPhone += "3";
                continue;
            }
            if( currentChar == 'g' || currentChar == 'h' || currentChar == 'i')
            {
                convertedPhone += "4";
                continue;
            }
            if( currentChar == 'j' || currentChar == 'k' || currentChar == 'l')
            {
                convertedPhone += "5";
                continue;
            }
            if( currentChar == 'm' || currentChar == 'n' || currentChar == 'o')
            {
                convertedPhone += "6";
                continue;
            }
            if( currentChar == 'p' || currentChar == 'q' || currentChar == 'r' || currentChar == 's')
            {
                convertedPhone += "7";
                continue;
            }
            if( currentChar == 't' || currentChar == 'u' || currentChar == 'v')
            {
                convertedPhone += "8";
                continue;
            }
            if( currentChar == 'w' || currentChar == 'x' || currentChar == 'y' || currentChar == 'z')
            {
                convertedPhone += "9";
                continue;
            }

            convertedPhone += currentChar;
        }

        return convertedPhone;
    }
}
