package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RecurringPayment {
    @JsonProperty("id")
    private String id;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("payer_email")
    private String payerEmail;

    @JsonProperty("description")
    private String description;

    @JsonProperty("amount")
    private Number amount;

    @JsonProperty("interval")
    private String interval;

    @JsonProperty("interval_count")
    private Number intervalCount;

    @JsonProperty("status")
    private String status;

    @JsonProperty("total_recurrence")
    private Number totalRecurrence;

    @JsonProperty("invoice_duration")
    private Number invoiceDuration;

    @JsonProperty("should_send_email")
    private Boolean shouldSendEmail;

    @JsonProperty("missed_payment_action")
    private String missedPaymentAction;

    @JsonProperty("credit_card_token")
    private String creditCardToken;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty("success_redirect_url")
    private String successRedirectUrl;

    @JsonProperty("failure_redirect_url")
    private String failureRedirectUrl;

    @JsonProperty("recharge")
    private Boolean recharge;

    @JsonProperty("charge_immediately")
    private Boolean chargeImmediately;

}
