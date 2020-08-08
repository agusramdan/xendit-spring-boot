package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Builder
@Data
@JsonInclude(NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @JsonProperty("id")
    private String id;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("merchant_name")
    private String merchantName;

    @JsonProperty("merchant_profile_picture_url")
    private String merchantProfilePictureUrl;

    @JsonProperty("bank_code")
    private String bankCode;

    @JsonProperty("amount")
    private Number amount;

    @JsonProperty("initial_amount")
    private Number initialAmount;

    @JsonProperty("payer_email")
    private String payerEmail;

    @JsonProperty("description")
    private String description;

    @JsonProperty("expiry_date")
    private String expiryDate;

    @JsonProperty("invoice_url")
    private String invoiceUrl;

    @JsonProperty("available_banks")
    private AvailableBankInvoice[] availableBanks;

    @JsonProperty("available_retail_outlets")
    private AvailableRetailOutletInvoice[] availableRetailOutlets;

    @JsonProperty("available_ewallets")
    private AvailableEwalletInvoice[] availableEwallets;

    @JsonProperty("paid_at")
    private String paidAt;

    @JsonProperty("paid_amount")
    private Number paidAmount;

    @JsonProperty("adjusted_received_amount")
    private Number adjustedReceivedAmount;

    @JsonProperty("should_exclude_credit_card")
    private Boolean shouldExcludeCreditCard;

    @JsonProperty("should_send_email")
    private Boolean shouldSendEmail;

    @JsonProperty("created")
    private String created;

    @JsonProperty("updated")
    private String updated;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("initial_currency")
    private String initialCurrency;

    @JsonProperty("on_demand_link")
    private String onDemandLink;

    @JsonProperty("on_demand_payload")
    private Object onDemandPayload;

    @JsonProperty("recurring_payment_id")
    private String recurringPaymentId;

    @JsonProperty("credit_card_charge_id")
    private String creditCardChargeId;

    @JsonProperty("mid_label")
    private String midLabel;

    @JsonProperty("payment_channel")
    private String paymentChannel;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("payment_destination")
    private String paymentDestination;

    @JsonProperty("success_redirect_url")
    private String successRedirectUrl;

    @JsonProperty("failure_redirect_url")
    private String failureRedirectUrl;

    @JsonProperty("items")
    private ItemInvoice[] items;

    @JsonProperty("fixed_va")
    private Boolean fixedVa;
}
