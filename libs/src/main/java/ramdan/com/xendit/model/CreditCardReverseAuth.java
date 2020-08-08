package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreditCardReverseAuth {
    @JsonProperty("id")
    private String id;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("business_id")
    private String businessId;

    @JsonProperty("merchant_reference_code")
    private String merchantReferenceCode;

    @JsonProperty("masked_card_number")
    private String maskedCardNumber;

    @JsonProperty("charge_type")
    private CreditCardEnum.ChargeType chargeType;

    @JsonProperty("card_brand")
    private String cardBrand;

    @JsonProperty("authorized_amount")
    private String authorizedAmount;

    @JsonProperty("status")
    private CreditCardEnum.ChargeStatus status;

    @JsonProperty("created")
    private String created;
}
