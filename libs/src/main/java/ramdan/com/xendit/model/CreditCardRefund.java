package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreditCardRefund {
    @JsonProperty("id")
    private String id;

    @JsonProperty("updated")
    private String updated;

    @JsonProperty("created")
    private String created;

    @JsonProperty("credit_card_charge_id")
    private String creditCardChargeId;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("amount")
    private Number amount;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("status")
    private CreditCardEnum.RefundStatus status;

    @JsonProperty("failure_reason")
    private CreditCardEnum.RefundFailureReason failureReason;

    @JsonProperty("fee_refund_amount")
    private Number feeRefundAmount;
}
