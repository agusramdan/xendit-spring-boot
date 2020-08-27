package ramdan.com.xendit.endpoint;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import ramdan.com.xendit.model.InvoiceParam;

import java.util.UUID;

import static ramdan.com.xendit.endpoint.InvoiceExpiredEndpoint.ENDPOINT_PATH;

@Disabled
public class InvoiceExpiredEndpointTest {
    @Test
    public void expireInvoice() {

        val service = new InvoiceCreateEndpoint();
        service.setUrl("https://api.xendit.co/v2/invoices");

        val restTemplate = new RestTemplate();
        service.setTemplate(restTemplate);
        restTemplate.getInterceptors().add(Const.basicAuth);

        val balance = service.create(InvoiceParam.builder()
                .externalId(UUID.randomUUID().toString())
                .payerEmail("test@gmail.com")
                .description("Testing Expried")
                .amount(11000)
                .build());

        Assertions.assertNotNull(balance.getId());

        val endpoint = new InvoiceExpiredEndpoint();
        endpoint.setUrl("https://api.xendit.co/" + ENDPOINT_PATH);
        endpoint.setTemplate(restTemplate);

        val exp = endpoint.expired(balance.getId());

        Assertions.assertNotNull(exp);
    }
}
