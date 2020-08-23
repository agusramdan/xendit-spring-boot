package ramdan.com.xendit.endpoint;

import ramdan.com.xendit.model.CardlessCredit;
import ramdan.com.xendit.model.CardlessCreditParam;

/**
 * Create invoice with all parameters as HashMap
 * listed here https://xendit.github.io/apireference/#cardless-credit
 */
public class CardlessCreditCreateEndpoint extends CreateEndpoint<CardlessCredit, CardlessCreditParam> {
    public static String ENDPOINT_PATH = "/cardless-credit";

    public CardlessCreditCreateEndpoint() {
        super(CardlessCredit.class);
    }

}
