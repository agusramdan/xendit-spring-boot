package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class XenditError {
    @JsonProperty("error_code")
    private String errorCode;

    @JsonProperty("message")
    private String message;

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
