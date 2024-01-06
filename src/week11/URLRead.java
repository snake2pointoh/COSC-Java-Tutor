package src.week11;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class URLRead {

    public static final String _URL = "https://liveexample.pearsoncmg.com/data/Lincoln.txt";

    public static void main(String[] args) {

        try {
            URL myURL = new URL(_URL);
            Scanner input = new Scanner(myURL.openStream());

            while (input.hasNext()) {
                System.out.println(input.nextLine());
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
