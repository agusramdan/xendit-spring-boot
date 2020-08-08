package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FixedVirtualAccountParam {

    /**
     * An ID of your choice. Often it is unique identifier
     * like a phone number, email or transaction ID.
     * Maximum length allowed is 1000 characters.
     * Note:
     * External IDs cannot be changed once set
     * Characters Special and alphanumeric
     * Minimum length 1 character
     */
    @JsonProperty(value = "external_id", required = true, index = 1)
    @Size(min = 1, max = 1000)
    private String externalId;

    /**
     * Bank code of the virtual account you want to create.
     * Note: We highly recommend you redirect customers to pay into BNI Virtual Account for interbank transfers
     * <p>
     * Available bank codes: MANDIRI, BNI, BRI, PERMATA, BCA, SAHABAT_SAMPOERNA
     * <p>
     * Characters Only alphabet
     * Minimum length 1 character
     */
    @JsonProperty(value = "bank_code", required = true, index = 2)
    @Size(min = 1, max = 40)
    private String bankCode;

    /**
     * Name of user/virtual account, - this will be displayed in the bank's user interface,
     * e.g. ATM confirmation screens.
     * Note that this field can only contain letters and spaces
     * and has no length restriction (though the banks will truncate as per their limitations)
     */
    @JsonProperty(value = "name", required = true, index = 3)
    private String name;

    /**
     * The virtual account number you want to assign. If you do not send one, one will be picked at random
     * Note: Please do not include the merchant code
     * (4 or 5 digit merchant prefix to the full virtual account number)
     * <p>
     * default: random string
     */
    @JsonProperty(value = "virtual_account_number", index = 4)
    private String virtualAccountNumber;


    /**
     * integer positive 	The suggested amount you want to assign.
     * Note: Suggested amounts is the amounts that can see as a suggestion, but user can still put
     * any numbers (only supported for Mandiri and BRI)
     * <p>
     * default: none
     */
    @JsonProperty(value = "suggested_amount", index = 5)
    private Long suggestedAmount;

    /**
     * When set to true, the virtual account will be closed and will only accept the amount specified in expected_amount
     * <p>
     * default: false
     */
    @JsonProperty(value = "is_closed", index = 6)
    private Boolean isClosed;

    /**
     * The specific amount that the virtual account will expect and accept if is_closed is set to true
     * <p>
     * default: none
     */
    @JsonProperty(value = "expected_amount", index = 7)
    private Long expectedAmount;

    /**
     * ISO 8601 Date 	The time when the virtual account will be expired
     * <p>
     * timezone: UTC
     * default: The expired date will be 31 years from VA generated
     */
    @JsonProperty(value = "expiration_date", index = 8)
    private String expirationDate;

    /**
     * When set to true, the virtual account will be inactive after it is paid
     * <p>
     * default: false
     */
    @JsonProperty(value = "is_single_use", index = 9)
    private Boolean isSingleUse;

    /**
     * The virtual account description. This field is only supported for BRI
     * <p>
     * Characters Special and alphanumeric
     * Minimum length 1 character
     * default: none
     */
    @JsonProperty(value = "description", index = 10)
    private String description;

}
