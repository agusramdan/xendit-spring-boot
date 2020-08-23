package ramdan.com.xendit.model;

import lombok.Builder;

public class EWalletOvo extends EWalletParam {
    @Builder
    public EWalletOvo(String externalId, Number amount, String phone, String callbackUrl, String redirectUrl) {
        super(EWalletType.OVO, externalId, amount, phone, callbackUrl, redirectUrl);
    }
}
