package ramdan.com.xendit.endpoint;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

@Disabled
public class VirtualAccountGetByIdEndpointTest {
    @Test
    public void getById() {
        val service = new VirtualAccountGetByIdEndpoint();
        service.setUrl("https://api.xendit.co" + VirtualAccountGetByIdEndpoint.ENDPOINT_PATH);

        val restTemplate = new RestTemplate();
        service.setTemplate(restTemplate);
        restTemplate.getInterceptors().add(Const.basicAuth);

        val balance = service.getById("843ba9c6-e8d9-42cf-8e49-16be19281b4f");

        Assertions.assertNotNull(balance.getId());
    }
}
