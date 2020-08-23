package ramdan.com.xendit.endpoint;

import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import ramdan.com.xendit.exception.XenditException;
import ramdan.com.xendit.model.CreditCardReverseAuth;
import ramdan.com.xendit.utils.MapBuilder;

/**
 * Expire an already created invoice
 * https://xendit.github.io/apireference/#expire-invoice.
 */
public class CreditCardReverseAuthEndpoint extends AbstractEndpoint<CreditCardReverseAuth> {
    public static String ENDPOINT_PATH = "/credit_card_charges/{chargeId}/auth_reversal";

    public CreditCardReverseAuthEndpoint() {
        super(CreditCardReverseAuth.class);
    }

    /**
     * https://xendit.github.io/apireference/#expire-invoice.
     *
     * @param chargeId ID of the invoice to be expired / canceled
     * @return Invoice
     * @throws XenditException XenditException
     */
    public CreditCardReverseAuth reverse(@NonNull String chargeId, String externalId) {
        return super.postForObject(null, chargeId);
    }

    /**
     * Expire an already created invoice
     *
     * @param chargeId    ID of the invoice to be expired / canceled
     * @param httpHeaders
     * @return Invoice
     * @throws XenditException XenditException
     */
    public CreditCardReverseAuth reverse(@NonNull String chargeId, String externalId, HttpHeaders httpHeaders) {
        return super.postForObject(MapBuilder
                .builder(String.class)
                .put("external_id", externalId)
                .build(), httpHeaders, chargeId);
    }
}
