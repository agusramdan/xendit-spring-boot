package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CardlessCredit {
    @JsonProperty("redirect_url")
    private String redirectUrl;

    @JsonProperty("transaction_id")
    private String transactionId;

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("cardless_credit_type")
    private String cardlessCreditType;

    public enum PaymentType {
        THIRTY_DAYS("30_days"),
        THREE_MONTHS("3_months"),
        SIX_MONTHS("6_months"),
        TWELVE_MONTHS("12_months");

        private String val;

        PaymentType(String val) {
            this.val = val;
        }

        public String getVal() {
            return this.val;
        }
    }
}
