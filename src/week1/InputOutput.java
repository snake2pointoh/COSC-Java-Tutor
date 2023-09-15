package src.week1;

import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {

        System.out.println("please enter your name:");
        Scanner obIn = new Scanner(System.in);

        System.out.printf("Hello %s", obIn.nextLine());
    }
}
