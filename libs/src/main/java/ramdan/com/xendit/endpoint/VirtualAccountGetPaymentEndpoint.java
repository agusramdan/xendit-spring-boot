package ramdan.com.xendit.endpoint;


import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import ramdan.com.xendit.exception.XenditException;
import ramdan.com.xendit.model.FixedVirtualAccountPayment;

public class VirtualAccountGetPaymentEndpoint extends AbstractEndpoint<FixedVirtualAccountPayment> {

    public static String ENDPOINT_PATH = "/callback_virtual_account_payments/payment_id={payment_id}";

    public VirtualAccountGetPaymentEndpoint() {
        super(FixedVirtualAccountPayment.class);
    }

    public FixedVirtualAccountPayment getById(@NonNull String id) {
        return super.getForObject(id);
    }

    /**
     * Get invoice detail by ID
     *
     * @param id         ID of the invoice to retrieve
     * @param httpHeader
     * @return Invoice
     * @throws XenditException XenditException
     */
    public FixedVirtualAccountPayment getById(@NonNull String id, @NonNull HttpHeaders httpHeader) throws XenditException {
        return super.getForObject(httpHeader, id);
    }

}
