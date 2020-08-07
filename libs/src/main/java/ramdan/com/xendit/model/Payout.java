package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Payout {
    @JsonProperty("id")
    private String id;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("amount")
    private Number amount;

    @JsonProperty("passcode")
    private String passcode;

    @JsonProperty("merchant_name")
    private String merchantName;

    @JsonProperty("status")
    private String status;

    @JsonProperty("expiration_timestamp")
    private String expirationTimestamp;

    @JsonProperty("created")
    private String created;

    @JsonProperty("payout_url")
    private String payoutUrl;

    @JsonProperty("email")
    private String email;

    @JsonProperty("bank_code")
    private String bankCode;

    @JsonProperty("account_holder_name")
    private String accountHolderName;

    @JsonProperty("account_number")
    private String accountNumber;

    @JsonProperty("disbursement_id")
    private String disbursementId;

    @JsonProperty("failure_reason")
    private String failureReason;

    @JsonProperty("claimed_timestamp")
    private String claimedTimestamp;

    @JsonProperty("completed_timestamp")
    private String completedTimestamp;

    @JsonProperty("failed_timestamp")
    private String failedTimestamp;

    @JsonProperty("payment_id")
    private String paymentId;

}
