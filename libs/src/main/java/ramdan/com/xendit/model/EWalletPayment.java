package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Builder
@Data
public class EWalletPayment {
    private static final BigInteger MINIMUM_AMOUNT = new BigInteger("1");
    private static final BigInteger MAXIMUM_AMOUNT = new BigInteger("10000000");
    @JsonProperty("id")
    private String id;
    @JsonProperty("external_id")
    private String externalId;
    @JsonProperty("business_id")
    private String businessId;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("amount")
    private Number amount;
    @JsonProperty("expiration_date")
    private String expirationDate;
    @JsonProperty("ewallet_type")
    private String ewalletType;
    @JsonProperty("transaction_date")
    private String transactionDate;
    @JsonProperty("checkout_url")
    private String checkoutUrl;
    @JsonProperty("status")
    private String status;

    public enum EWalletType {
        DANA,
        OVO,
        LINKAJA
    }
}
