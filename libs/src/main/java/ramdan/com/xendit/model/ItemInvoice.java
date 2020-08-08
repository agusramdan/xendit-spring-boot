package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
@NoArgsConstructor
public class ItemInvoice {
    @JsonProperty("name")
    String name;

    @JsonProperty("price")
    Number price;

    @JsonProperty("quantity")
    Number quantity;
}
