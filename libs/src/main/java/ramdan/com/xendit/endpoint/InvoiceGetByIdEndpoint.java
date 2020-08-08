package ramdan.com.xendit.endpoint;


import lombok.NonNull;
import ramdan.com.xendit.model.Invoice;

public class InvoiceGetByIdEndpoint extends AbstractEndpoint<Invoice> {
    public InvoiceGetByIdEndpoint() {
        super(Invoice.class);
    }

    public Invoice getById(@NonNull String id){
        return super.getForObject(id);
    }
}
