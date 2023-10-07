package src.week3;

public class CountCharInString {
    public static void main(String[] args) {
        String phrase = "https://portal.saskpolytech.ca/student/Pages/default.aspx";

        System.out.printf("there were %d instances of %s\n", countCharIn(phrase,'a'),'a');

        System.out.printf("there were %d instances of %s\n", countCharIn(phrase,'b'),'b');

        System.out.printf("there were %d instances of %s\n", countCharIn(phrase,'c'),'c');

        System.out.printf("there were %d instances of %s\n", countCharIn(phrase,'d'),'d');

    }

    public static int countCharIn(String sVal, char cVal)
    {
        int nCount = 0;

        for (int i = 0; i < sVal.length(); i++)
        {
            if(sVal.charAt(i) == cVal)
            {
                nCount++;
            }
        }

        return nCount;
    }
}
