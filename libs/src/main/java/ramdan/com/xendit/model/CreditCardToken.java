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
@JsonInclude(NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardToken {
    /**
     * The token ID. This will be used later to Charge the funds from the credit card
     */
    @JsonProperty(value = "id", required = true, index = 1)
    private String id;

    /**
     * optional 	string
     * Returned only if authentication was bundled with tokenization.
     * Xendit.js bundles authentication with single-use token creation by default,
     * but not for multiple-use token creation.
     */
    @JsonProperty(value = "authentication_id", required = true, index = 2)
    private String authenticationId;


    /**
     * The first 6 digits and last 4 digits of the tokenized card.
     */
    @JsonProperty(value = "masked_card_number", required = true, index = 3)
    private String maskedCardNumber;

    /**
     * Tokenization status. See Tokenization Statuses
     */
    @JsonProperty(value = "status", required = true, index = 4)
    private String status;

    /**
     * Tokenization status. See Tokenization Statuses
     */
    @JsonProperty(value = "payer_authentication_url", required = true, index = 5)
    private String payerAuthenticationUrl;

    /**
     * Tokenization status. See Tokenization Statuses
     */
    @JsonProperty(value = "failure_reason", required = true, index = 6)
    private String failureReason;
    /*

status
required 	string
payer_authentication_url
optional 	string 	Returned only if authentication is bundled with tokenization, and the status returned is IN_REVIEW. This field contains the URL to the page for users to authenticate themselves using 3DS. See Tokenization Statuses.

failure_reason
optional 	string 	If the tokenization status is FAILED, this describes the reason for failure. See Tokenization Failure Reasons.
     */
}
