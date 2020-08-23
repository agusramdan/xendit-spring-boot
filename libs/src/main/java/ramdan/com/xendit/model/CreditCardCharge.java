package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Builder
@Data
@JsonInclude(NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardCharge {
    @JsonProperty("id")
    private String id;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("created")
    private String created;

    @JsonProperty("status")
    private CreditCardEnum.ChargeStatus status;

    @JsonProperty("business_id")
    private String businessId;

    @JsonProperty("authorized_amount")
    private Number authorizedAmount;

    @JsonProperty("merchant_id")
    private String merchantId;

    @JsonProperty("merchant_reference_code")
    private String merchantReferenceCode;

    @JsonProperty("card_type")
    private CreditCardEnum.CardType cardType;

    @JsonProperty("masked_card_number")
    private String maskedCardNumber;

    @JsonProperty("charge_type")
    private CreditCardEnum.ChargeType chargeType;

    @JsonProperty("card_brand")
    private String cardBrand;

    @JsonProperty("bank_reconciliation_id")
    private String bankReconciliationId;

    @JsonProperty("eci")
    private CreditCardEnum.EciCode eci;

    @JsonProperty("capture_amount")
    private Number captureAmount;

    @JsonProperty("descriptor")
    private String descriptor;

    @JsonProperty("failure_reason")
    private CreditCardEnum.FailureReason failureReason;
}
