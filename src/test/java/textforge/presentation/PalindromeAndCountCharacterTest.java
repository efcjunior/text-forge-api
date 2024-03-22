package textforge.presentation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import textforge.domain.TextAnalyzer;
import textforge.dto.RequestTextInputDTO;
import textforge.dto.ResponseTextAnalysisResultDTO;
import textforge.domain.AnalysisResult;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PalindromeAndCountCharacterTest {

    @Mock
    private TextAnalyzer textAnalyzer;

    @InjectMocks
    private PalindromeAndCountCharacter controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessText_ValidInput() {

        RequestTextInputDTO request = new RequestTextInputDTO("\"ovo\"");

        AnalysisResult analysisResult =
                new AnalysisResult(false, Map.of('o',2, 'v',1));

        when(textAnalyzer.analyzeText(request.getText())).thenReturn(analysisResult);

        ResponseEntity<Object> response = controller.processText(request);

        assertEquals(200, response.getStatusCodeValue());
        ResponseTextAnalysisResultDTO responseBody = (ResponseTextAnalysisResultDTO) response.getBody();

        assertEquals(false, responseBody.isPalindrome());
        assertEquals(Map.of('o',2, 'v',1), responseBody.getCharacterOccurrences());
        verify(textAnalyzer, times(1)).analyzeText(request.getText());
    }

    @Test
    public void testProcessText_EmptyInput() {

        RequestTextInputDTO request = new RequestTextInputDTO();
        request.setText("");

        ResponseEntity<Object> response = controller.processText(request);

        assertEquals(400, response.getStatusCodeValue());
        Map<String, String> responseBody = (Map<String, String>) response.getBody();

        assertEquals("Campo texto vazio", responseBody.get("error"));
        verify(textAnalyzer, never()).analyzeText(any());
    }


    @Test
    public void testProcessText_ExceptionThrown() {
        // Arrange
        RequestTextInputDTO request = new RequestTextInputDTO("some text");

        when(textAnalyzer.analyzeText(request.getText())).thenThrow(new RuntimeException("Some exception"));

        ResponseEntity<Object> response = controller.processText(request);

        assertEquals(400, response.getStatusCodeValue());
        Map<String, String> responseBody = (Map<String, String>) response.getBody();

        assertEquals("Falha no processamento", responseBody.get("error"));
        verify(textAnalyzer, times(1)).analyzeText(request.getText());
    }
}
