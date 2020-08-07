package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
public class FixedVirtualAccountPayment {
    @JsonProperty("id")
    String id;

    @JsonProperty("payment_id")
    String paymentId;

    @JsonProperty("callback_virtual_account_id")
    String callbackVirtualAccountId;

    @JsonProperty("external_id")
    String externalId;

    @JsonProperty("account_number")
    String accountNumber;

    @JsonProperty("merchant_code")
    String merchantCode;

    @JsonProperty("bank_code")
    String bankCode;

    @JsonProperty("amount")
    Number amount;

    @JsonProperty("transaction_timestamp")
    String transactionTimeStamp;

    @JsonProperty("currency")
    String currency;
}
