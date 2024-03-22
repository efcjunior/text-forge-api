package textforge.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterCount {
    public static Map<Character, Integer> countCharacters(final String text) {
        Map<Character, Integer> characterCount = new LinkedHashMap<>();

        if(text == null || text.trim().isEmpty()){
            return characterCount;
        }

        for (char c : text.toCharArray()) {
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        }

        return characterCount;
    }
}
