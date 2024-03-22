package textforge.domain;

import java.util.Map;

public class AnalysisResult {
    private final Boolean palindrome;
    private final Map<Character, Integer> characterOccurrences;

    public AnalysisResult(Boolean palindrome, Map<Character, Integer> characterOccurrences) {
        this.palindrome = palindrome;
        this.characterOccurrences = characterOccurrences;
    }
    public Boolean isPalindrome() {
        return palindrome;
    }

    public Map<Character, Integer> getCharacterOccurrences() {
        return characterOccurrences;
    }
}
