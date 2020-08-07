package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
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
