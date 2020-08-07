package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BatchDisbursement {
    @JsonProperty("id")
    private String id;

    @JsonProperty("created")
    private String created;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("total_uploaded_count")
    private Number totalUploadedCount;

    @JsonProperty("total_uploaded_amount")
    private Number totalUploadedAmount;

    @JsonProperty("status")
    private String status;

}
