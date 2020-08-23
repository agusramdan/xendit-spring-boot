package ramdan.com.xendit.endpoint;


import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import ramdan.com.xendit.exception.XenditException;
import ramdan.com.xendit.model.Invoice;

public class InvoiceGetByIdEndpoint extends AbstractEndpoint<Invoice> {

    public static String ENDPOINT_PATH = "/v2/invoices/{id}";

    public InvoiceGetByIdEndpoint() {
        super(Invoice.class);
    }

    public Invoice getById(@NonNull String id) {
        return getById(id, null);
    }

    /**
     * Get invoice detail by ID
     *
     * @param id         ID of the invoice to retrieve
     * @param httpHeader
     * @return Invoice
     * @throws XenditException XenditException
     */
    public Invoice getById(@NonNull String id, HttpHeaders httpHeader) throws XenditException {
        return super.getForObject(httpHeader, id);
    }

}
