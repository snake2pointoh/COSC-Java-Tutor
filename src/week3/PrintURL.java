package src.week3;

public class PrintURL {
    public static void main(String[] args) {
        // https://portal.saskpolytech.ca/student/Pages/default.aspx
        String myURL = "https://portal.saskpolytech.ca/student/Pages/default.aspx";

        while (myURL.length() > 0)
        {
            myURL = printURLPart(myURL);
        }
    }

    public static String printURLPart(String url) {
        String urlRemainder = "";

        int indexOfSlash = url.indexOf('/');

        if(indexOfSlash >= 0) {
            String urlPart = url.substring(0,indexOfSlash);
            System.out.println(urlPart);
            urlRemainder = url.substring(indexOfSlash+1);
        }
        else
        {
            System.out.println(url);
        }

        return urlRemainder;

    }
}
