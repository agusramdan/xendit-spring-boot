package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BatchDisbursementItem {
    @JsonProperty("amount")
    private Number amount;

    @JsonProperty("bank_code")
    private String bankCode;

    @JsonProperty("bank_account_name")
    private String bankAccountName;

    @JsonProperty("bank_account_number")
    private String bankAccountNumber;

    @JsonProperty("description")
    private String description;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("email_to")
    private String[] emailTo;

    @JsonProperty("email_cc")
    private String[] emailCC;

    @JsonProperty("email_bcc")
    private String[] emailBcc;
}
