package textforge.domain;

import org.springframework.stereotype.Service;
import java.util.Map;


@Service
public class TextAnalyzer {
    public AnalysisResult analyzeText(String text) {
        boolean isPalindrome = PalindromeChecker.isPalindrome(text);
        Map<Character, Integer> characterCounts = CharacterCount.countCharacters(text);
        return new AnalysisResult(isPalindrome, characterCounts);
    }
}