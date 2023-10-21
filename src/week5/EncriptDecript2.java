package src.week5;

public class EncriptDecript2 {
    public static void main(String[] args) {
        String myStr = "saskpoly";

        String enryped = encryptStringModArray(myStr);
        System.out.println(enryped);

        System.out.println(decryptStringMod(enryped));

//        String encString = encryptString(myStr);
//        System.out.println(encString);
//
//        String decriptString = decryptString(encString);
//        System.out.println(decriptString);
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

    public static String encryptStringMod(String strr) {
        String encryptedStr = "";
        String alpha = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < strr.length(); i++) {
            char currentCharacter = strr.charAt(i);
            if(currentCharacter == ' ') {
                encryptedStr += currentCharacter;
                continue;
            }

            int posInAlpha = alpha.indexOf(currentCharacter);

            posInAlpha = posInAlpha + 7;
            // clamp value to 0-25
            if(posInAlpha >= alpha.length()) {
                posInAlpha = posInAlpha % alpha.length();
            }

            encryptedStr += alpha.charAt(posInAlpha);

        }

        return encryptedStr;
    }

    public static String encryptStringModArray(String strr) {
        String encryptedStr = "";
        char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
                'n','o','p','q','r','s','t','u','v','w','x','y','z'};

        for (int i = 0; i < strr.length(); i++) {
            char currentCharacter = strr.charAt(i);
            if(currentCharacter == ' ') {
                encryptedStr += currentCharacter;
                continue;
            }

            int posInAlpha = findPosInCharArray(alpha, currentCharacter); // replace with array search

            posInAlpha = posInAlpha + 7;
            // clamp value to 0-25
            if(posInAlpha >= alpha.length) {
                posInAlpha = posInAlpha % alpha.length;
            }

            encryptedStr += alpha[posInAlpha];

        }

        return encryptedStr;
    }

    public static int findPosInCharArray(char[] arr, char myChar) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == myChar) {
                return i;
            }
        }

        return -1;
    }

    public static String decryptStringMod(String strr) {
        String encryptedStr = "";
        String alpha = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < strr.length(); i++) {
            char currentCharacter = strr.charAt(i);
            if(currentCharacter == ' ') {
                encryptedStr += currentCharacter;
                continue;
            }

            int posInAlpha = alpha.indexOf(currentCharacter);

            posInAlpha = posInAlpha - 7;
            // clamp value to 0-25
            if(posInAlpha < 0) {
                posInAlpha = posInAlpha + alpha.length();
            }

            encryptedStr += alpha.charAt(posInAlpha);

        }

        return encryptedStr;
    }
}
