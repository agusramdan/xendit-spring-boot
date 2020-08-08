package ramdan.com.xendit.endpoint;


import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import ramdan.com.xendit.exception.XenditException;
import ramdan.com.xendit.model.FixedVirtualAccount;

public class VirtualAccountGetByIdEndpoint extends AbstractEndpoint<FixedVirtualAccount> {

    public static String ENDPOINT_PATH = "/callback_virtual_accounts/{id}";

    public VirtualAccountGetByIdEndpoint() {
        super(FixedVirtualAccount.class);
    }

    public FixedVirtualAccount getById(@NonNull String id) {
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
    public FixedVirtualAccount getById(@NonNull String id, @NonNull HttpHeaders httpHeader) throws XenditException {
        return super.getForObject(httpHeader, id);
    }

}
