package ramdan.com.xendit.endpoint;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@Disabled
public class VirtualAccountGetPaymentEndpointTest {
    BasicAuthenticationInterceptor basicAuth = new BasicAuthenticationInterceptor("xnd_development_kzvpE88d7xACeo4mbZ3fc3om9t6c1GwlA5KGLKdI96rMPZvfhFKEKBDE9iPsyLG", "");

    @Test
    public void getById() {
        val service = new VirtualAccountGetPaymentEndpoint();
        service.setUrl("https://api.xendit.co" + VirtualAccountGetPaymentEndpoint.ENDPOINT_PATH);

        val restTemplate = new RestTemplate();
        service.setTemplate(restTemplate);
        restTemplate.getInterceptors().add(basicAuth);

        val balance = service.getById("843ba9c6-e8d9-42cf-8e49-16be19281b4f");

        Assertions.assertNotNull(balance.getId());
    }
}
