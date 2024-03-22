package textforge.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import textforge.dto.RequestTextInputDTO;
import textforge.domain.AnalysisResult;
import textforge.domain.TextAnalyzer;
import textforge.dto.ResponseTextAnalysisResultDTO;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
public class PalindromeAndCountCharacter {

    @Autowired
    private TextAnalyzer textAnalyzer;

    @PostMapping("/manipulacao-string")
    public ResponseEntity<Object> processText(@RequestBody RequestTextInputDTO requestTextInputDTO) {

        try {
            if (requestTextInputDTO.getText() == null || requestTextInputDTO.getText().trim().isEmpty()) {
                return ResponseEntity.badRequest().body(createErrorResponse("Campo texto vazio"));
            }

            AnalysisResult analysisResult = textAnalyzer.analyzeText(requestTextInputDTO.getText());

            ResponseTextAnalysisResultDTO responseTextAnalysisResultDTO = new ResponseTextAnalysisResultDTO(
                    analysisResult.isPalindrome(),
                    analysisResult.getCharacterOccurrences()
            );

            return ResponseEntity.ok(responseTextAnalysisResultDTO);

        }catch (Exception ex) {
            return ResponseEntity.badRequest().body(createErrorResponse("Falha no processamento"));
        }
    }

    private Map<String, String> createErrorResponse(String message) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", message);
        return errorResponse;
    }
}
