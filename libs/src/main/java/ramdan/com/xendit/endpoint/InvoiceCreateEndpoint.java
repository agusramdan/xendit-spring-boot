package ramdan.com.xendit.endpoint;

import ramdan.com.xendit.model.Invoice;
import ramdan.com.xendit.model.InvoiceParam;

/**
 * Create invoice with all parameters as HashMap
 * listed here https://xendit.github.io/apireference/#create-invoice.
 */
public class InvoiceCreateEndpoint extends CreateEndpoint<Invoice, InvoiceParam> {
    public static String ENDPOINT_PATH = "/v2/invoices";

    public InvoiceCreateEndpoint() {
        super(Invoice.class);
    }

}
