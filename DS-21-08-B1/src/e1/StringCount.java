package e1;

import java.util.Locale;

public class StringCount {

    /**
     * Counts the number of words in a given String.
     * Words are groups of characters separated by one or more spaces.
     * @param text String with the words.
     * @return Number of words in the String or zero if it is null.
     */

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

    /**
     * Counts the number of times the given character appears in the String.
     * Accented characters are considered different characters.
     * @param text String with the characters.
     * @param c the character to be found.
     * @return Number of times the character appears in the String or zero if null.
     */

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

    /**
     * Counts the number of times the given character appears in the String.
     * The case is ignored so an ’a’ is equal to an ’A’.
     * Accented characters are considered different characters.
     * @param text String with the characters.
     * @param c the character to be found.
     * @return Number of times the character appears in the String or zero if null.
     */

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

    /**
     * Checks if a password is safe according to the following rules:
     *      - Has at least 8 characters.
     *      - Has an uppercase character.
     *      - Has a lowercase character.
     *      - Has a digit.
     *      - Has a special character among these : ’? ’, ’@ ’, ’#’, ’$ ’, ’. ’ and ’,’.
     * @param password The password , we assume it is not null.
     * @return true if the password is safe , false otherwise.
     */

    public static boolean isPasswordSafe(String password) {
        // PreCD: password is not null
        boolean lowCase = false, upCase = false, digit = false, special = false;
        char[] charArray = password.toCharArray();
        int[] specials = {'?', '@', '#', '$', '.', ','};

        for (char c : charArray) {
            if (Character.isLowerCase(c)) {
                lowCase = true;
            }

            if (Character.isUpperCase(c)) {
                upCase = true;
            }

            if (Character.isDigit(c)) {
                digit = true;
            }

            for (int i : specials) {
                if (c == i) {
                    special = true;
                    break;
                }
            }
        }
        return password.length() >= 8 && upCase && lowCase && digit && special;
    }
}

