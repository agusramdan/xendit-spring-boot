package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class FixedVirtualAccount {

    @JsonProperty("id")
    private String id;

    @JsonProperty("owner_id")
    private String ownerId;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("merchant_code")
    private String merchantCode;

    @JsonProperty("account_number")
    private String accountNumber;

    @JsonProperty("bank_code")
    private String bankCode;

    @JsonProperty("name")
    private String name;

    @JsonProperty("is_closed")
    private Boolean isClosed;

    @JsonProperty("expiration_date")
    private Date expirationDate;

    @JsonProperty("is_single_use")
    private Boolean isSingleUse;

    @JsonProperty("status")
    private String status;

    // optionals
    @JsonProperty("suggested_amount")
    private Long suggestedAmount;

    @JsonProperty("expected_amount")
    private Long expectedAmount;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("description")
    private String description;

}
