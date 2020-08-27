package ramdan.com.xendit.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import ramdan.com.xendit.utils.ISO8601TimeFormat;
import ramdan.com.xendit.utils.MapBuilder;

import java.util.Date;

@Disabled
public class InvoiceGetAllEndpointTest {

    @Test
    public void getAll() {
        val service = new InvoiceGetAllEndpoint();
        service.setUrl("https://api.xendit.co/v2/invoices");

        val restTemplate = new RestTemplate();
        service.setTemplate(restTemplate);
        restTemplate.getInterceptors().add(Const.basicAuth);

        val balance = service.getAll();

        Assertions.assertNotNull(balance);
    }

    @Test
    public void getAllStatusPending() {


        val service = new InvoiceGetAllEndpoint();
        service.setUrl("https://api.xendit.co/v2/invoices");

        val restTemplate = new RestTemplate();
        service.setTemplate(restTemplate);
        restTemplate.getInterceptors().add(Const.basicAuth);

        val balance = service.getAll(MapBuilder
                .builder(String.class)
                .put("statuses", "[\"PENDING\"]")
                .put("limit", 2)
                .build());

        Assertions.assertNotNull(balance);
    }

    @Test
    public void getAllDate() throws JsonProcessingException {

        String expired_before = ISO8601TimeFormat.format(new Date());

        val service = new InvoiceGetAllEndpoint();
        service.setUrl("https://api.xendit.co/v2/invoices");

        val restTemplate = new RestTemplate();
        service.setTemplate(restTemplate);
        restTemplate.getInterceptors().add(Const.basicAuth);

        val balance = service.getAll(MapBuilder
                .builder(String.class)
                .put("expired_before", expired_before)
                .put("limit", 2)
                .build());

        Assertions.assertNotNull(balance);
    }
}
