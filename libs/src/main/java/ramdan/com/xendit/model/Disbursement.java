package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigInteger;

@Builder
@Data
public class Disbursement {
    private static final BigInteger MINIMUM_AMOUNT = new BigInteger("10000");
    private static final BigInteger MAXIMUM_AMOUNT = new BigInteger("25000000");

    @JsonProperty("id")
    private String id;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("amount")
    @Max(25000000)
    @Min(10000)
    private BigInteger amount;

    @JsonProperty("bank_code")
    private String bankCode;

    @JsonProperty("account_holder_name")
    private String accountHolderName;

    @JsonProperty("disbursement_description")
    private String disbursementDescription;

    @JsonProperty("status")
    private String status;

    // optionals
    @JsonProperty("email_to")
    private String[] emailTo;

    @JsonProperty("email_cc")
    private String[] emailCC;

    @JsonProperty("email_bcc")
    private String[] emailBcc;
}
