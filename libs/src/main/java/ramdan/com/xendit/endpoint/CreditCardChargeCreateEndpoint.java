package ramdan.com.xendit.endpoint;

import ramdan.com.xendit.model.CreditCardCharge;
import ramdan.com.xendit.model.CreditCardChargeParam;

/**
 * Create authorization with parameters in a HashMap
 * <p>
 * https://xendit.github.io/apireference/#create-charge
 * <p>
 * https://api.xendit.co/v2/credit_card_tokens
 */
public class CreditCardChargeCreateEndpoint extends CreateEndpoint<CreditCardCharge, CreditCardChargeParam> {
    public static String ENDPOINT_PATH = "/credit_card_charges";

    public CreditCardChargeCreateEndpoint() {
        super(CreditCardCharge.class);
    }
}
