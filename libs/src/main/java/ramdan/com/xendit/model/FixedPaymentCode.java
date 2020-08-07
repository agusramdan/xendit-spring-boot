package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
public class FixedPaymentCode {
    @JsonProperty("id")
    private String id;
    @JsonProperty("owner_id")
    private String ownerId;
    @JsonProperty("external_id")
    private String externalId;
    @JsonProperty("retail_outlet_name")
    private RetailOutletName retailOutletName;
    @JsonProperty("prefix")
    private String prefix;
    @JsonProperty("name")
    private String name;
    @JsonProperty("payment_code")
    private String paymentCode;
    @JsonProperty("type")
    private String type;
    @JsonProperty("expected_amount")
    private Number expectedAmount;
    @JsonProperty("status")
    private String status;
    @JsonProperty("is_single_use")
    private Boolean isSingleUse;
    @JsonProperty("expiration_date")
    private String expirationDate;

    public enum RetailOutletName {
        ALFAMART,
        INDOMARET
    }
}
