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
public class CardlessCreditCalculate {

    /**
     * message
     * required
     * string “Available payment types are listed
     */
    private String message;


    /**
     * payments
     * required
     * array List of calculated payment types
     */
    @JsonProperty("payments")
    @NotNull
    private CardlessCreditCalculatePayment[] payments;


}
