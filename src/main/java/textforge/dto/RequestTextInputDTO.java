package textforge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestTextInputDTO {
    @JsonProperty("texto")
    private String text;

    public RequestTextInputDTO(){
    }
    public RequestTextInputDTO(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

