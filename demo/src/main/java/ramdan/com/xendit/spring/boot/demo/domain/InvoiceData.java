package ramdan.com.xendit.spring.boot.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import ramdan.com.xendit.model.AvailableBankInvoice;
import ramdan.com.xendit.model.AvailableEwalletInvoice;
import ramdan.com.xendit.model.AvailableRetailOutletInvoice;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "invoice")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceData {
    @Id
    private Long id;

    @Version
    private Integer version;

    @CreatedBy
    @Column(name = "created_by",updatable = false)
    private String createdBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at",updatable = false)
    private Date createdAt;

    @LastModifiedBy
    @Column(name = "modified_by")
    private String modifiedBy;

    @LastModifiedDate
    @Column(name = "modified_at")
    private Date modifiedAt;

    @Column(name = "xendit_id")
    private String xenditId;

    @Column(name = "xendit_userid")
    private String xenditUserId;

    @Email
    @Column(name="payer_email")
    @NotNull
    private String payerEmail;

    @Column(name="should_send_email")
    private Boolean shouldSendEmail ;

    private String currency;
    @NotNull
    private BigInteger amount;

    @Column(name="initial_amount")
    private BigInteger initialAmount;

    @NotNull
    private String description;

    @Column(name="expiry_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;

    @Column(name="invoice_url")
    private String invoiceUrl;

    @Column(name="success_redirect_url")
    private String successRedirectUrl;

    @Column(name="failure_redirect_url")
    private String failureRedirectUrl;

    @Column(name="paid_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paidAt;

    @Column(name="paid_amount")
    private BigInteger paidAmount;

    private String status;
}
