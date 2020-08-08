package ramdan.com.xendit.endpoint;

import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import ramdan.com.xendit.exception.XenditException;
import ramdan.com.xendit.model.Invoice;

/**
 * Expire an already created invoice
 * https://xendit.github.io/apireference/#expire-invoice.
 */
public class InvoiceExpiredEndpoint extends AbstractEndpoint<Invoice> {
    public static String ENDPOINT_PATH = "/invoices/{invoice_id}/expire!";

    public InvoiceExpiredEndpoint() {
        super(Invoice.class);
    }

    /**
     * https://xendit.github.io/apireference/#expire-invoice.
     *
     * @param invoice_id ID of the invoice to be expired / canceled
     * @return Invoice
     * @throws XenditException XenditException
     */
    public Invoice expired(@NonNull String invoice_id) {
        return super.postForObject(null, invoice_id);
    }

    /**
     * Expire an already created invoice
     *
     * @param invoice_id  ID of the invoice to be expired / canceled
     * @param httpHeaders
     * @return Invoice
     * @throws XenditException XenditException
     */
    public Invoice expired(@NonNull String invoice_id, HttpHeaders httpHeaders) {
        if (httpHeaders != null) {
            return super.postForObject(null, httpHeaders, invoice_id);
        } else {
            return expired(invoice_id);
        }
    }
}
