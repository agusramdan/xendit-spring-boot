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
public class CreditCardChargeParam {

    /**
     * TODO
     * The token ID. This will be used later to Charge the funds from the credit card
     */
    @JsonProperty(value = "token_id", required = true, index = 1)
    private String tokenId;

    /**
     * TODO
     * optional 	string
     * Returned only if authentication was bundled with tokenization.
     * Xendit.js bundles authentication with single-use token creation by default,
     * but not for multiple-use token creation.
     */
    @JsonProperty(value = "external_id", required = true, index = 2)
    private String externalId;


    /**
     * TODO
     * The first 6 digits and last 4 digits of the tokenized card.
     */
    @JsonProperty(value = "amount", required = true, index = 3)
    private Number amount;

    /**
     * TODO
     * Tokenization status. See Tokenization Statuses
     */
    @JsonProperty(value = "authentication_id", required = true, index = 4)
    private String authenticationId;

    /**
     * TODO
     * Tokenization status. See Tokenization Statuses
     */
    @JsonProperty(value = "card_cvn", required = true, index = 5)
    private String cardCVN;

    /**
     * TODO
     * Tokenization status. See Tokenization Statuses
     */
    @JsonProperty(value = "capture", required = true, index = 6)
    private Boolean capture;
}
