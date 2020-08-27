package ramdan.com.xendit.endpoint;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

@Disabled
public class InvoiceGetByIdEndpointTest {
    @Test
    public void getById() {
        val service = new InvoiceGetByIdEndpoint();
        service.setUrl("https://api.xendit.co" + InvoiceGetByIdEndpoint.ENDPOINT_PATH);

        val restTemplate = new RestTemplate();
        service.setTemplate(restTemplate);
        restTemplate.getInterceptors().add(Const.basicAuth);

        val balance = service.getById("1");

        Assertions.assertNotNull(balance.getId());
    }
}
