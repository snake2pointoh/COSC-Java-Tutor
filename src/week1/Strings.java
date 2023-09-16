package src.week1;

public class Strings {
    public static void main(String[] args) {
        String name = "nick";

        System.out.println(name.charAt(0)); // n

        System.out.println(name.indexOf('i')); // 1

        String URL = "https://portal.saskpolytech.ca/student/Pages/default.aspx";

        System.out.printf("STR length: %d\n", URL.length());

        //look for the LAST occurrence of the / char
        System.out.println(URL.lastIndexOf('/')); // 44
        System.out.println(URL.indexOf('/')); // 6

        String subURLMid = URL.substring(URL.indexOf('/') + 1,URL.length());
        System.out.println(subURLMid);

        //using the last value of subURLMid as the input as the next step.
        subURLMid = subURLMid.substring(subURLMid.indexOf('/') + 1, subURLMid.length()); // "/portal.saskpolytech.ca/student/Pages/default.aspx"
        System.out.println(subURLMid);

        subURLMid = subURLMid.substring(subURLMid.indexOf('/') + 1, subURLMid.length());
        System.out.println(subURLMid);

        String subURL= URL.substring(URL.lastIndexOf('/') + 1,URL.length()); // default.aspx or /default.aspx

        System.out.println(subURL);
    }
}
