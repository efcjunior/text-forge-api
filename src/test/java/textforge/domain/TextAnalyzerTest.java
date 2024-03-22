package textforge.domain;

import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextAnalyzerTest {

    @Test
    public void testAnalyzeText_AnalysisResult() {

        TextAnalyzer textAnalyzer = new TextAnalyzer();

        AnalysisResult result = textAnalyzer.analyzeText("radar");

        assertEquals(true, result.isPalindrome());
        assertEquals(Map.of('r',2,'a',2, 'd',1), result.getCharacterOccurrences());
    }
}
