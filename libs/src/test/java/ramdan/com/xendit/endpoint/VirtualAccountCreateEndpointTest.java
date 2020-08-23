package ramdan.com.xendit.endpoint;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import ramdan.com.xendit.model.FixedVirtualAccountParam;
import ramdan.com.xendit.model.InvoiceParam;
import ramdan.com.xendit.utils.MapBuilder;

import java.util.UUID;

import static ramdan.com.xendit.endpoint.VirtualAccountCreateEndpoint.ENDPOINT_PATH;

@Disabled
public class VirtualAccountCreateEndpointTest {


    @Test
    public void createVirtualAccount() {

        val service = new VirtualAccountCreateEndpoint();
        service.setUrl("https://api.xendit.co" + ENDPOINT_PATH);

        val restTemplate = new RestTemplate();
        service.setTemplate(restTemplate);
        restTemplate.getInterceptors().add(Const.basicAuth);

        val balance = service.create(FixedVirtualAccountParam.builder()
                .externalId(UUID.randomUUID().toString())
                .bankCode("BRI")
                .name("Dono Kasino Indro")
                .virtualAccountNumber("9999000003")
                .description("Testing Bayar")
                .build());


        //5f2ec180e577286591c68549
        Assertions.assertNotNull(balance.getId());
    }

    @Test
    public void createInvoiceMap() {
        val service = new InvoiceCreateEndpoint();
        service.setUrl("https://api.xendit.co" + ENDPOINT_PATH);

        val restTemplate = new RestTemplate();
        service.setTemplate(restTemplate);
        restTemplate.getInterceptors().add(Const.basicAuth);

        val balance = service.create(MapBuilder.builder(String.class)
                .put("external_id", UUID.randomUUID().toString())
                .put("payer_email", "agusramdan@gmail.com")
                .put("description", "Testing Bayar")
                .put("amount", 11000)
                .build());

        Assertions.assertNotNull(balance.getId());
    }

    @Test
    public void createInvoiceParam() {
        val service = new InvoiceCreateEndpoint();
        service.setUrl("https://api.xendit.co" + ENDPOINT_PATH);

        val restTemplate = new RestTemplate();
        service.setTemplate(restTemplate);
        restTemplate.getInterceptors().add(Const.basicAuth);

        val balance = service.create(InvoiceParam.builder()
                .externalId(UUID.randomUUID().toString())
                .payerEmail("agusramdan@gmail.com")
                .description("Testing Bayar")
                .amount(11000)
                //.callbackVirtualAccountId("08529525279")
                .fixedVa(true)
                .build());

        Assertions.assertNotNull(balance.getId());
    }
}
