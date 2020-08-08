package ramdan.com.xendit.endpoint;

import ramdan.com.xendit.model.AvailableBank;

/**
 * Get all invoices by given parameters
 * <p>
 * https://xendit.github.io/apireference/#get-virtual-account-banks
 */
public class AvailableVirtualAccountBanksEndpoint extends AbstractEndpoint<AvailableBank[]> {

    public static String ENDPOINT_PATH = "/available_virtual_account_banks";

    public AvailableVirtualAccountBanksEndpoint() {
        super(AvailableBank[].class);
    }

    public AvailableBank[] getAll() {
        return super.getForObjectParamQuery(null);
    }
}
