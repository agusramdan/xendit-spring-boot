package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Builder
@Data
//@JsonInclude(NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardTokenParam {
    /**
     * The charge amount.
     * Only required for single use tokens with bundled authentication.
     */
    @JsonProperty(value = "amount", index = 1)
    private String amount;

    @JsonProperty(value = "card_data", index = 2)
    CreditCardData cardData;

    /**
     * default: false 	boolean 	Whether or not to save token for multiple use
     */
    @JsonProperty(value = "is_single_use", required = true, index = 6)
    private Boolean singleUse;
//    /**
//     * default: false 	boolean 	Whether or not to save token for multiple use
//     */
//    @JsonProperty(value = "is_multiple_use", required = true, index = 6)
//    private Boolean multipleUse;

    /**
     * default: true 	boolean 	Whether or not to bundle authentication with tokenization.
     * By default, authentication is required for all transactions.
     * You can request to enable optional authentication via your Xendit Dashboard.
     */
    @JsonProperty(value = "should_authenticate", required = true, index = 7)
    private Boolean shouldAuthenticate;

/*
xenditResponseHandler
required 	function
The response handler function is called after tokenization is attempted,
 to receive errors and tokenization response
     */
    @Data
    @JsonInclude(NON_EMPTY)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreditCardData {
        /**
         * Card number
         */
        @JsonProperty(value = "account_number", required = true, index = 2)
        private String cardNumber;

        /**
         * Card expiration month
         */
        @JsonProperty(value = "exp_month", required = true, index = 3)
        private String cardExpMonth;

        /**
         * Card expiration year
         */
        @JsonProperty(value = "exp_year", required = true, index = 4)
        private String cardExpYear;

        /**
         * Card CVN/CVV code
         * Optional but highly recommended. Required for cards issued in Europe.
         */
        @JsonProperty(value = "cvn", required = true, index = 5)
        private String cardCvn;
    }
}
