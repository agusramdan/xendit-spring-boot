package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Builder
@Data
@JsonInclude(NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceParam {

    /**
     * ID of your choice (typically the unique identifier of an invoice in your system)
     */
    @JsonProperty(value = "external_id", required = true, index = 1)
    private String externalId;

    /**
     * Email of the end user you're charging
     */
    @JsonProperty(value = "payer_email", required = true, index = 2)
    private String payerEmail;

    /**
     * Description of the invoice
     */
    @JsonProperty(value = "description", required = true, index = 3)
    private String description;

    /**
     * Amount on the invoice. The minimum amount to create an invoice is 1 IDR or PHP
     */
    @JsonProperty(value = "amount", required = true, index = 4)
    private Number amount;

    /**
     * Specify whether you want us to email the end customer when an invoice is created, paid, or expired
     */
    @JsonProperty(value = "should_send_email", index = 5, defaultValue = "false")
    private Boolean shouldSendEmail;
    /**
     * To allow payment via Fixed Virtual Account, pass in the id field value from the response when the
     * fixed virtual account was created. See Create Fixed Virtual Accounts
     */
    @JsonProperty(value = "callback_virtual_account_id", index = 6)
    private String callbackVirtualAccountId;

    /**
     * Duration of time that the end customer is given to pay the invoice before expiration (in seconds, since creation)
     */
    @JsonProperty(value = "invoice_duration", required = true, index = 7)
    private Number invoiceDuration;

    /**
     * URL that the end customer will be redirected to upon successful invoice payment.
     * example : https://<span></span>yourcompany.com/example_item/10/success_page
     */
    @JsonProperty(value = "success_redirect_url", index = 8)
    private String successRedirectUrl;

    /**
     * URL that end user will be redirected to upon expiration of this invoice.
     * example : https://<span></span>yourcompany.com/example_item/10/failed_checkout
     */
    @JsonProperty(value = "failure_redirect_url", index = 9)
    private String failureRedirectUrl;

    /**
     * array of strings
     * <p>
     * Choice of payment channels that is available in your account. Leave this
     * field empty if all payment channel is expected to be available in this particular invoice,
     * or if you want to use the defaults set in your Xendit Dashboard.
     * <p>
     * example : <span></span>
     * ["BCA", "BRI", "MANDIRI", "BNI", <br>
     * "PERMATA", "ALFAMART", "CREDIT_CARD", <br>
     * "OVO"]
     */
    @JsonProperty(value = "payment_methods", index = 10)
    private String[] paymentMethods;

    /**
     * MID label when you have an acquiring bank, and are using credit cards.
     */
    @JsonProperty(value = "mid_label", index = 11)
    private String midLabel;

    /**
     * Currency of the amount that you created
     * example : "IDR" or "PHP"
     */
    @JsonProperty(index = 12)
    private String currency;

    /**
     * default: false
     * boolean 	Input this parameter as true to enable using a single,
     * persistent VA number your end customers,
     * determined by email address.
     */
    @JsonProperty(value = "fixed_va", index = 13)
    private Boolean fixedVa;

    /**
     * integer positive
     * Reminder email will be sent reminder_time day(s) before the invoice expires.
     * Allowed values are 1, 3, 7, 15, 30 days before invoice expires
     */
    @JsonProperty(value = "reminder_time", required = true, index = 7)
    @Min(1)
    @Max(30)
    private Number reminderTime;

}
