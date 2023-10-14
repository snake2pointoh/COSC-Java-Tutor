package src.week4;

public class EncriptDecript {
    public static void main(String[] args) {
        String myStr = "saskpoly";
        String encString = encryptString(myStr);
        System.out.println(encString);

        String decriptString = decryptString(encString);
        System.out.println(decriptString);
    }

    public static String encryptString(String sVal) {
        String alpha   = "abcdefghijklmnopqrstuvwxyz";
        String encript = "qwertyuiopasdfghjklzxcvbnm";

        String encriptedString = "";

        for(int i = 0; i < sVal.length(); i++ )
        {
            char currentChar = sVal.charAt(i);
            int indexOfChar = alpha.indexOf(currentChar);

            encriptedString += encript.charAt(indexOfChar);
        }

        return encriptedString;
    }

    public static String decryptString(String sVal) {
        String alpha   = "abcdefghijklmnopqrstuvwxyz";
        String encript = "qwertyuiopasdfghjklzxcvbnm";

        String decriptedString = "";
        for (int i = 0; i < sVal.length(); i++) {
            char currentChar = sVal.charAt(i);
            int indexOfChar = encript.indexOf(currentChar);

            decriptedString += alpha.charAt(indexOfChar);
        }

        return decriptedString;
    }
}
