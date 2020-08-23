package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * https://xendit.github.io/apireference/?bash#payment-callback-notification
 * <p>
 * Payment Callback Notification
 * Callback Payload
 * You need to provide an endpoint in your system to receive payment callback notification from our system.
 * We will send the payment callback notification when the end-customer completes the payment on the Checkout page.
 * <p>
 * The payment callback notification will be sent as POST request to the "callback_url" that you sepecified on the
 * Generate Checkout URL request.
 */
@Builder
@Data
@JsonInclude(NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
public class CardlessCreditCallback {

    /**
     * external_id	string
     * <p>
     * Your transaction identifier that you specified in on the Generate Checkout URL request.
     */
    @JsonProperty("external_id")
    private String externalId;

    /**
     * order_id	string
     * <p>
     * Unique Identifier that we gave to the cardless credit payment partner.
     */
    @JsonProperty("order_id")
    private String orderId;

    /**
     * transaction_id	string
     * <p>
     * Transaction ID given by Cardless Credit partner.
     */
    @JsonProperty("transaction_id")
    private String transactionId;

    /**
     * transaction_status	string
     * <p>
     * Transaction status, the value is:
     * <p>
     * settlement : Transaction is successful
     * pending    : End-User has not completed the transaction
     * deny       : Transaction has been denied by our Cardless Credit Partner
     * cancel     : Transaction has been cancelled
     * expire     : End-User did not complete transaction in 24 hours, thus transaction is expired
     */
    @JsonProperty("transaction_status")
    private String transactionStatus;

    /**
     * payment_type
     * <p>
     * the type of installment.
     * <p>
     * <p>
     * <p>
     * amount	number	Amount that you specified in on the Generate Checkout URL request.
     * items	array of item	List of items / products that you specified in on the Generate Checkout URL request.
     * item object
     * item detail	Details of an item, it should contains: id [string], name [string], price [number], type [string], url [string], quantity [number]
     * customer_details	object	Details of the customer, it should contains: first_name [string], last_name [string], email [string], phone [string]
     * shipping_address	object	Details of the shipping address, it should contains: first_name [string], last_name [string], address [string], city [string], postal_code [string], phone [string], country_code [string]
     * cardless_credit_type	string	The type of cardless-credit.
     * Supported Cardless Credit types: KREDIVO
     * callback_authentication_token	string	Your Callback Verfication API Key that you can found on your Xendit Dashboard. You need to verify if this had the same value.
     */
    @JsonProperty("payment_type")
    private String paymentType;

    /**
     * amount	number	Amount that you specified in on the Generate Checkout URL request.
     */
    @JsonProperty("amount")
    private Number amount;

    /**
     * items	array of item
     * <p>
     * List of items / products that you specified in on the Generate Checkout URL request.
     * <p>
     * item object
     * item object	Details of an item, it should contains:
     * <p>
     * id [string],
     * name [string],
     * price [number],
     * type [string],
     * url [string],
     * quantity [number]
     */
    @JsonProperty("items")
    private CardlessCreditItem[] items;
    /**
     * customer_details
     * required
     * object	Details of the customer, it should contains:
     * first_name [string],
     * last_name [string],
     * email [string],
     * phone [string]
     */
    @JsonProperty("customer_details")
    private CardlessCreditCustomer customerDetails;

    /**
     * shipping_address
     * required
     * object	Details of the shipping address, it should contains:
     * <p>
     * first_name [string],
     * last_name [string],
     * address [string],
     * city [string],
     * postal_code [string],
     * phone [string],
     * country_code [string]
     */
    @JsonProperty("shipping_address")
    private CardlessCreditShippingAddress shippingAddress;

    /**
     * cardless_credit_type required
     * <p>
     * string	The type of cardless-credit to be paid. Must be in capital letters.
     * Supported Cardless Credit types: KREDIVO
     */
    @JsonProperty("cardless_credit_type")
    private String cardlessCreditType;

    /**
     * callback_authentication_token	string
     * <p>
     * Your Callback Verfication API Key that you can found on your Xendit Dashboard.
     * You need to verify if this had the same value.
     */
    @JsonProperty("callback_authentication_token")
    private String callbackAuthenticationToken;

}
