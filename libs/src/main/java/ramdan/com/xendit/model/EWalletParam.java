package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * eWallets
 * <p>
 * Currently, Xendit supports OVO, DANA and LINKAJA as an e-Wallet payment method.
 * <p>
 * eWallet payment channel allows you to receive payments directly from top ewallets provider in Indonesia,
 * <p>
 * such as OVO, DANA, and LinkAja.
 */
@Data
@JsonInclude(NON_EMPTY)
@AllArgsConstructor
public class EWalletParam {
    /**
     * ewallet_type
     * required
     * string	ewallet_type must be in capital letters - 'OVO'
     */
    @JsonProperty("ewallet_type")
    private EWalletType walletType;

    /**
     * external_id
     * required
     * string	An ID of your choice. Often it is unique identifier like a phone number, email or transaction ID.
     * Note: The only allowed punctuation is -.
     * Note: Maximum length allowed is 50 characters.
     * Note: It has to be unique per payment request.
     */
    @JsonProperty("external_id")
    private String externalId;

    /**
     * amount
     * required
     * number	Amount end-customer will pay.
     * Note: minimum amount is 1 IDR and maximum is 10,000,000 IDR
     */
    @JsonProperty("amount")
    private Number amount;

    /**
     * phone
     * required
     * string	Phone number of end-customer (e.g. 08123123123)
     * Note: End-customer must have an active ewallet account registered to Indonesian phone number prior to payment request.
     * Note: Phone number format should always be "088889998888" (not using "+62").
     */
    @JsonProperty("phone")
    private String phone;

    /**
     * callback_url
     * required
     * string	The URL to receive the callback after payment made by end-customer
     */
    @JsonProperty("callback_url")
    private String callbackUrl;

    /**
     * redirect_url
     * required
     * string	The URL to redirect to after payment made by end-customer
     */
    @JsonProperty("redirect_url")
    private String redirectUrl;
}
