package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * https://xendit.github.io/apireference/#cardless-credit
 */
@Builder
@Data
@JsonInclude(NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
public class CardlessCreditParam {

    /**
     * cardless_credit_type required
     * <p>
     * string	The type of cardless-credit to be paid. Must be in capital letters.
     * Supported Cardless Credit types: KREDIVO
     */
    @JsonProperty("cardless_credit_type")
    @NotNull
    private String cardlessCreditType;

    /**
     * external_id
     * required
     * string	An ID of your choice. Often it is unique identifier like a phone number, email or transaction ID. Maximum length allowed is 1000 characters.
     */
    @JsonProperty("external_id")
    @NotNull
    private String externalId;

    /**
     * amount required
     * number	Amount end customer will pay.
     * Note: minimum amount is 1 IDR
     */
    @JsonProperty("amount")
    @NotNull
    private Number amount;

    /**
     * payment_type
     * required
     * string	The type of installment, you can choose between: "30_days", "3_months", "6_months" and "12_months".
     */
    @JsonProperty("payment_type")
    @NotNull
    private PaymentType paymentType;

    /**
     * items
     * required
     * array of item object	List of items / products.
     * item object
     * required
     * item object	Details of an item, it should contains: id [string], name [string], price [number], type [string], url [string], quantity [number]
     */
    @JsonProperty("items")
    @NotNull
    private CardlessCreditItem[] items;

    /**
     * customer_details
     * required
     * object	Details of the customer, it should contains: first_name [string], last_name [string], email [string], phone [string]
     */
    @JsonProperty("customer_details")
    @NotNull
    private CardlessCreditCustomer customerDetails;

    /**
     * shipping_address
     * required
     * object	Details of the shipping address, it should contains: first_name [string], last_name [string], address [string], city [string], postal_code [string], phone [string], country_code [string]
     */
    @JsonProperty("shipping_address")
    @NotNull
    private CardlessCreditShippingAddress shippingAddress;

    /**
     * redirect_url
     * required
     * string	After end-customer complete the checkout they will be redirected to the url that you specify in this field. You can put your transaction details page or your home page.
     */
    @JsonProperty("redirect_url")
    private String redirectUrl;

    /**
     * callback_url
     * required
     * string	We will send callback to this address when the customer completes the payment proccess.
     */
    @JsonProperty("callback_url")
    private String callbackUrl;

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
