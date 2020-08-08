package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_NULL)
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
