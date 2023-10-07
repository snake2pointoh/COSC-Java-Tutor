package src.week3;

public class Palindromes {
    public static void main(String[] args) {
        String testString = "race car";
//        String testString = "my house";

        System.out.printf("the reverse of %s, is %s\n", testString, reverseString(testString));

//          if(isPalindrome(testString))
//          {
//              System.out.printf("%s is a palindrome!\n", testString);
//          }
//          else
//          {
//              System.out.printf("%s is not a palindrome!\n", testString);
//          }

          System.out.printf("%s is%s a palindrome!\n",
                  testString, isPalindrome(testString)? "" : " not");

          System.out.printf("%s reversed with no spaces is %s\n", testString, reverseStringNoSpace(testString));
          System.out.printf("%s with no spaces is%s a palindrome\n", testString, isPalindromeNoSpace(testString)? "" : " not");

    }

    public static boolean isPalindrome(String sVal)
    {
        String reverse = reverseString(sVal);
        if(sVal.equals(reverse))
        {
            return true;
        }

        return false;
    }

    public static String reverseString(String sVal)
    {
        String reverse = "";

        for (int i = sVal.length() - 1; i >= 0; i--)
        {
            reverse += sVal.charAt(i);
        }

        return reverse;
    }


    public static boolean isPalindromeNoSpace(String sVal)
    {
        //check if the string is a palindrome while ignoring the spaces
        String reverse = reverseStringNoSpace(sVal);

        sVal = removeSpaces(sVal);
        if(sVal.equals(reverse))
        {
            return true;
        }

//        String noSpaceVal = "";
//        for (int i = 0; i < sVal.length(); i++)
//        {
//            char currentChar = sVal.charAt(i);
//            if(currentChar != ' ')
//            {
//                noSpaceVal += currentChar;
//            }
//        }
//        if(noSpaceVal.equals(reverse))
//        {
//            return true;
//        }

        return false;
    }

    // EXAMPLE
    // INPUT: race car
    // OUTPUT racecar
    //
    // INPUT: my house
    // OUTPUT esuohmy
    public static String reverseStringNoSpace(String sVal)
    {
        String reverse = "";
        sVal = removeSpaces(sVal);

        for (int i = sVal.length()-1; i >= 0; i--)
        {
            char currentChar = sVal.charAt(i);
//            if(currentChar != ' ')
//            {
//                reverse += currentChar;
//            }
            reverse += currentChar;
        }

        return reverse;
    }

    public static String removeSpaces(String sVal)
    {
        String returnString = "";

        for (int i = 0; i < sVal.length(); i++)
        {
            char currentChar = sVal.charAt(i);
            if(currentChar != ' ')
            {
                returnString += currentChar;
            }
        }

        return returnString;
    }
}
