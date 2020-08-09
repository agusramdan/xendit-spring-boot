package ramdan.com.xendit.endpoint;

import ramdan.com.xendit.model.Invoice;

/**
 * Create invoice with all parameters as HashMap
 * listed here https://xendit.github.io/apireference/#create-invoice.
 */
public class InvoiceCreateEndpoint extends CreateEndpoint<Invoice> {
    public static String ENDPOINT_PATH = "/v2/invoices";

    public InvoiceCreateEndpoint() {
        super(Invoice.class);
    }

}
