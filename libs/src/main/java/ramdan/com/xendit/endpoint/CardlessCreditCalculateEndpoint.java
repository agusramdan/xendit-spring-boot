package ramdan.com.xendit.endpoint;

import ramdan.com.xendit.model.CardlessCreditCalculate;
import ramdan.com.xendit.model.CardlessCreditCalculateParam;

/**
 * Create Payment / Generate Checkout URL
 * <p>
 * Use API key permission Money-in Write to perform this request
 * <p>
 * listed here https://xendit.github.io/apireference/#calculate-payment-types
 */
public class CardlessCreditCalculateEndpoint extends AbstractEndpoint<CardlessCreditCalculate> {
    public static String ENDPOINT_PATH = "/cardless-credit/payment-types";

    public CardlessCreditCalculateEndpoint() {
        super(CardlessCreditCalculate.class);
    }

    public CardlessCreditCalculate calculate(CardlessCreditCalculateParam param) {
        return super.postForObject(param);
    }

}
