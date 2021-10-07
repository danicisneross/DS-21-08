package e1;

import java.util.Locale;

public class StringCount {

    public static int countWords(String text) {
        int count = 0;

        if (text != null) {
            String text1 = text.replaceAll(" +", " ").trim();
            if (!text.isEmpty()) {
                count++;
            }
            for (int i = 0; i < text1.length(); i++) {
                if (text1.charAt(i) == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countChar(String text, char c) {
        int count = 0;

        if (text != null) {
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == c) {
                    count++;
                }
            }

        }
        return count;
    }

    public static int countCharIgnoringCase(String text, char c) {
        int count = 0;

        if (text != null) {
            String text1 = text.toLowerCase(Locale.ROOT);
            char c1 = Character.toLowerCase(c);

            for (int i = 0; i < text1.length(); i++) {
                if (text1.charAt(i) == c1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPasswordSafe(String password) {
        // PreCD: password is not null
        boolean lowCase = false, upCase = false, digit = false, special = false;
        char[] charArray = password.toCharArray();
        int[] specials = {'?', '@', '#', '$', '.', ','};

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLowerCase(charArray[i])) {
                lowCase = true;
            }

            if (Character.isUpperCase(charArray[i])) {
                upCase = true;
            }

            if (Character.isDigit(charArray[i])) {
                digit = true;
            }

            for (int j = 0; j < specials.length; j++) {
                if (charArray[i] == specials[j]) {
                    special = true;
                }
            }
        }

        if (password.length() >= 8 && upCase && lowCase && digit && special) {
            return true;
        } else return false;
    }
}

