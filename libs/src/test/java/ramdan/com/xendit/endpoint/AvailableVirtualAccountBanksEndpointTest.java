package ramdan.com.xendit.endpoint;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

@Disabled
public class AvailableVirtualAccountBanksEndpointTest {


    @Test
    public void getAll() {
        val service = new AvailableVirtualAccountBanksEndpoint();
        service.setUrl("https://api.xendit.co" + AvailableVirtualAccountBanksEndpoint.ENDPOINT_PATH);

        val restTemplate = new RestTemplate();
        service.setTemplate(restTemplate);
        restTemplate.getInterceptors().add(Const.basicAuth);

        val balance = service.getAll();

        Assertions.assertNotNull(balance);
    }

}
