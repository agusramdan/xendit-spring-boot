package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CardlessCreditShippingAddress {
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("city")
    private String city;

    @JsonProperty("postal_code")
    private String postalCode;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("country_code")
    private String countryCode;
}
