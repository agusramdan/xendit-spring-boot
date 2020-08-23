package ramdan.com.xendit.endpoint;

import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import ramdan.com.xendit.exception.XenditException;
import ramdan.com.xendit.model.CreditCardRefund;
import ramdan.com.xendit.utils.MapBuilder;

/**
 * Expire an already created invoice
 * https://xendit.github.io/apireference/#expire-invoice.
 */
public class CreditCardRefundEndpoint extends AbstractEndpoint<CreditCardRefund> {
    public static String ENDPOINT_PATH = "/credit_card_charges/{id}/refunds";

    public CreditCardRefundEndpoint() {
        super(CreditCardRefund.class);
    }

    /**
     * https://xendit.github.io/apireference/#expire-invoice.
     *
     * @param invoice_id ID of the invoice to be expired / canceled
     * @return Invoice
     * @throws XenditException XenditException
     */
    public CreditCardRefund refund(@NonNull String invoice_id, String externalId) {
        return super.postForObject(null, invoice_id);
    }

    /**
     * Expire an already created invoice
     *
     * @param id          ID
     * @param httpHeaders
     * @return Invoice
     * @throws XenditException XenditException
     */
    public CreditCardRefund refund(String id, Number amount, String externalId, HttpHeaders httpHeaders) {
        return super.postForObject(MapBuilder
                .builder(String.class)
                .put("amount", amount)
                .put("external_id", externalId)
                .build(), httpHeaders, id);
    }
}
