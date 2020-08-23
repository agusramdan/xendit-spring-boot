package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * https://xendit.github.io/apireference/#cardless-credit
 */
@Builder
@Data
@JsonInclude(NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
public class CardlessCreditCalculateParam {

    /**
     * cardless_credit_type required
     * <p>
     * string	The type of cardless-credit to be paid. Must be in capital letters.
     * Supported Cardless Credit types: KREDIVO
     */
    @JsonProperty("cardless_credit_type")
    @NotNull
    private String cardlessCreditType;

    /**
     * amount required
     * number	Amount end customer will pay.
     * Note: minimum amount is 1 IDR
     */
    @JsonProperty("amount")
    @NotNull
    private Number amount;

    /**
     * items
     * required
     * array of item object	List of items / products.
     * item object
     * required
     * item object	Details of an item, it should contains: id [string], name [string], price [number], type [string], url [string], quantity [number]
     */
    @JsonProperty("items")
    @NotNull
    private CardlessCreditItem[] items;


}
