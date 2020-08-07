package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Balance {
    @JsonProperty("balance")
    private Number balance;

    public enum AccountType {
        CASH,
        HOLDING,
        TAX
    }

}
