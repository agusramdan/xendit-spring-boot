package ramdan.com.xendit.endpoint;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import ramdan.com.xendit.model.EWalletOvo;
import ramdan.com.xendit.model.EWalletType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EWalletPaymentCreateEndpointTest {
    @Test
    public void buildOvo() {
        assertEquals(EWalletType.OVO, EWalletOvo.builder().build().getWalletType());
    }

    @Test
    public void createOvo() {
        val service = new EWalletPaymentCreateEndpoint();
        service.setUrl("https://api.xendit.co" + EWalletPaymentCreateEndpoint.ENDPOINT_PATH);

        val restTemplate = new RestTemplate();
        service.setTemplate(restTemplate);
        restTemplate.getInterceptors().add(Const.basicAuth);

        val param = EWalletOvo.builder()
                .externalId("test-cardless-credit-01")
                .amount(800000)
                .phone("0865412322")
                .callbackUrl("")
                .build();
        val balance = service.create(param, null);

        assertNotNull(balance);
    }
}
