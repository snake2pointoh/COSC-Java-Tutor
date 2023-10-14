package src.week4;

public class SortMyString {
    public static void main(String[] args) {
        String myString = "Saskpoly";

        System.out.printf("%s sorted Ascending is %s", myString, sortAscending(myString));

        System.out.printf("%s sorted Descending is %s", myString, sortDescending(myString));
    }

    public static String sortAscending(String sVal) {

        String sorted = "";
        sVal = sVal.toLowerCase();

        while (sVal.length() > 0) {
            // loop through the string to find the smallent and remove it
            char smallestChar = 'z';
            int smallestPos = 0;
            for (int i = 0; i < sVal.length(); i++) {
                char currenChar = sVal.charAt(i);
                if(currenChar < smallestChar)
                {
                    smallestChar = currenChar;
                    smallestPos = i;
                }
            }
            sorted += smallestChar;
            sVal = sVal.substring(0,smallestPos) + sVal.substring(smallestPos+1);
        }

        return sorted;
    }

    public static String sortDescending(String sVal) {
        String sorted = "";
        sVal = sVal.toLowerCase();

        while (sVal.length() > 0)
        {
            char largestChar = 'a'; // track LARGEST value in the remainder of the string
            int largestPos = 0;
            for (int i = 0; i < sVal.length(); i++)
            {
                char currentChar = sVal.charAt(i);
                if(currentChar > largestChar)
                {
                    largestChar = currentChar;
                    largestPos = i;
                }
            }
            sorted += largestChar;
            sVal = sVal.substring(0, largestPos) + sVal.substring(largestPos-1);
        }

        return sorted;
    }
}
