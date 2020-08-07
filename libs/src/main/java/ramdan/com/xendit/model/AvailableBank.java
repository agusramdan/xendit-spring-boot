package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AvailableBank {
    @JsonProperty("name")
    String name;

    @JsonProperty("code")
    String code;

    @JsonProperty("can_disburse")
    Boolean canDisburse;

    @JsonProperty("can_name_validate")
    Boolean canNameValidate;
}
