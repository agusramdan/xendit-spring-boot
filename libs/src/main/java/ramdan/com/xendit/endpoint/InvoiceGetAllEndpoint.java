package ramdan.com.xendit.endpoint;

import ramdan.com.xendit.exception.XenditException;
import ramdan.com.xendit.model.Invoice;
import sun.awt.SunHints;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Get all invoices by given parameters
 *
 * https://xendit.github.io/apireference/#list-all-invoices
 */
public class InvoiceGetAllEndpoint extends AbstractEndpoint<Invoice[]> {

    public static Set<String> filterField = new HashSet<>(Arrays.asList(
            "statuses",
            "limit",
            "created_after",
            "created_before",
            "paid_after",
            "paid_before",
            "expired_after",
            "expired_before",
            "last_invoice_id",
            "client_types",
            "payment_channels",
            "on_demand_link",
            "recurring_payment_id"
            ));
    public InvoiceGetAllEndpoint() {
        super(Invoice[].class);
    }

    /**
     * Get all invoices by given parameters
     *
     * @param params  listed here https://xendit.github.io/apireference/#list-all-invoices
     * @return Array of invoices
     * @throws XenditException XenditException
     */
    public Invoice[] getAll(Map<String,Object> params) throws XenditException {
        if(params!=null && !params.isEmpty()) {
            params = params.entrySet()
                    .stream()
                    .filter(map -> filterField.contains(map.getKey()))
                    .collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue()));
        }
        return super.getForObjectParamQuery(params);
    }

        public Invoice[] getAll(){
            return super.getForObjectParamQuery(null);
        }
}
