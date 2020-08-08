package ramdan.com.xendit.endpoint;

import ramdan.com.xendit.model.Invoice;

public class InvoiceCreateEndpoint extends AbstractEndpoint<Invoice> {
    public InvoiceCreateEndpoint() {
        super(Invoice.class);
    }

    public Invoice create(Invoice invoice){
        return super.postForObject(invoice);
    }
}
