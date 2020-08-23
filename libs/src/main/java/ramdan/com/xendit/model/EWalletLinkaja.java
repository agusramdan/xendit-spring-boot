package ramdan.com.xendit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EWalletLinkaja extends EWalletParam {
    /**
     * expiration_date
     * optional
     * string	End-customer cannot complete the payment past the expiration date
     * Timezone: UTC unless specified (e.g. 2020-03-20T04:54:10+07:00)
     * Expiry: Default expiry is 24 hours unless specified.
     */
    @JsonProperty("items")
    private EWalletLinkajaItem[] items;

    @Builder
    public EWalletLinkaja(String externalId, Number amount, String phone, String callbackUrl, String redirectUrl, EWalletLinkajaItem[] items) {
        super(EWalletType.LINKAJA, externalId, amount, phone, callbackUrl, redirectUrl);
        this.items = items;
    }
}
