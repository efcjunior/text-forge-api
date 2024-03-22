package textforge.domain;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class PalindromeChecker {

    private static final Pattern NON_ASCII_PATTERN = Pattern.compile("[^\\p{ASCII}]");
    private static final Pattern NON_ALPHANUMERIC_PATTERN = Pattern.compile("\\s");

    public static boolean isPalindrome(final String text) {

        if (text == null || text.trim().isEmpty()) {
            return false;
        }

        String cleanText = Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll(NON_ASCII_PATTERN.pattern(), "")
                .replaceAll(NON_ALPHANUMERIC_PATTERN.pattern(), "")
                .toLowerCase();

        int left = 0;
        int right = cleanText.length() - 1;

        while (left < right) {
            if (cleanText.charAt(left) != cleanText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
