package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class ItemInvoice {
    @JsonProperty("name")
    String name;

    @JsonProperty("price")
    Number price;

    @JsonProperty("quantity")
    Number quantity;
}
