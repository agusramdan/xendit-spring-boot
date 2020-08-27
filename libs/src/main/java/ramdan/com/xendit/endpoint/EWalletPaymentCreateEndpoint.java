package ramdan.com.xendit.endpoint;

import org.springframework.http.HttpHeaders;
import ramdan.com.xendit.model.EWalletOvo;
import ramdan.com.xendit.model.EWalletPayment;

/**
 * Create Payment / Generate Checkout URL
 * <p>
 * Use API key permission Money-in Write to perform this request
 * <p>
 * listed here https://xendit.github.io/apireference/#calculate-payment-types
 */
public class EWalletPaymentCreateEndpoint extends AbstractEndpoint<EWalletPayment> {
    public static String ENDPOINT_PATH = "/ewallets";

    public EWalletPaymentCreateEndpoint() {
        super(EWalletPayment.class);
    }

    public EWalletPayment create(EWalletOvo param, String userId) {
        HttpHeaders httpHeaders = newHttpHeadersForUserId(userId);
        if (httpHeaders == null) {
            httpHeaders = new HttpHeaders();
        }
        httpHeaders.add("x-api-version", "2020-02-01");
        return super.postForObject(param);
    }

}
