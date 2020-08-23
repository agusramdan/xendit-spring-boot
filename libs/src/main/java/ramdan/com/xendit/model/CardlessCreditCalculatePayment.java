package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * https://xendit.github.io/apireference/#cardless-credit
 */
@Builder
@Data
@JsonInclude(NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
public class CardlessCreditCalculatePayment {

    /**
     * payments.raw_monthly_installment
     * required
     * number Monthly installment before rounding
     */
    @JsonProperty("raw_monthly_installment")
    private Number rawMonthlyInstallment;

    /**
     * payments.name
     * required
     * string Name of installment plan
     */
    @JsonProperty("name")
    private String name;


    /**
     * payments.amount
     * required
     * number Total payment amount before interest
     */
    @JsonProperty("amount")
    private Number amount;

    /**
     * payments.installment_amount
     * required
     * number Total payment amount after interest
     */
    @JsonProperty("installment_amount")
    private Number installmentAmount;

    /**
     * payments.raw_amount
     * required
     * number Payment amount before interest before rounding
     */
    @JsonProperty("raw_amount")
    private Number rawAmount;

    /**
     * payments.rate
     * required
     * number Applied interest rates
     */
    @JsonProperty("rate")
    private Number rate;

    /**
     * payments.down_payment
     * required
     * number Amount paid upfront
     */
    @JsonProperty("down_payment")
    private Number downPayment;

    /**
     * payments.monthly_installment
     * required
     * number Monthly installment offered by Kredivo to end user
     */
    @JsonProperty("monthly_installment")
    private Number monthlyInstallment;


    /**
     * payments.discounted_monthly_installment
     * required
     * number Monthly installment offered by Kredivo to end user after discount (if any)
     */
    @JsonProperty("discounted_monthly_installment")
    private Number discountedMonthlyInstallment;

    /**
     * payments.tenure
     * required
     * number Repayment term of installment in months
     * <p>
     * payments.id
     * required
     * string ID of installment type
     */
    @JsonProperty("tenure")
    private Number tenure;

    /**
     * payments.id
     * required
     * string ID of installment type
     */
    @JsonProperty("id")
    private String id;

}
