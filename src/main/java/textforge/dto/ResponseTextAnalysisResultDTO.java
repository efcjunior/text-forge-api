package textforge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class ResponseTextAnalysisResultDTO {

    @JsonProperty("palindromo")
    private final Boolean palindrome;
    @JsonProperty("ocorrencias_caracteres")
    private final Map<Character, Integer> characterOccurrences;

    public ResponseTextAnalysisResultDTO(Boolean palindrome, Map<Character, Integer> characterOccurrences) {
        this.palindrome = palindrome;
        this.characterOccurrences = characterOccurrences;
    }
    public Boolean isPalindrome(){
        return this.palindrome;
    }
    public Map<Character, Integer> getCharacterOccurrences() {
        return characterOccurrences;
    }
}
