package ramdan.com.xendit.endpoint;

import ramdan.com.xendit.model.CreditCardToken;
import ramdan.com.xendit.model.CreditCardTokenParam;

/**
 * Create authorization with parameters in a HashMap
 *
 * https://xendit.github.io/apireference/#create-charge
 *
 * https://api.xendit.co/v2/credit_card_tokens
 */
public class CreditCardTokenCreateEndpoint extends CreateEndpoint<CreditCardToken, CreditCardTokenParam> {
      public static String ENDPOINT_PATH = "/v2/credit_card_tokens";

    public CreditCardTokenCreateEndpoint() {
        super(CreditCardToken.class);
    }
}
