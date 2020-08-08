package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@AllArgsConstructor
@Data
@JsonInclude(NON_NULL)
@NoArgsConstructor
public class Balance {
    @JsonProperty("balance")
    private Number balance;

    public enum AccountType {
        CASH,
        HOLDING,
        TAX
    }

}
