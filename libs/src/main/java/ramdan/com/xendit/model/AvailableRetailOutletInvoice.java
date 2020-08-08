package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
@NoArgsConstructor
public class AvailableRetailOutletInvoice {
    @JsonProperty("retail_outlet_name")
    private String retailOutletName;

    @JsonProperty("payment_code")
    private String paymentCode;

    @JsonProperty("transfer_amount")
    private Number transferAmount;

    @JsonProperty("merchant_name")
    private String merchantName;
}
