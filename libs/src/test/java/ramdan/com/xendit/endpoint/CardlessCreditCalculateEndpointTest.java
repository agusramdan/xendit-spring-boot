package ramdan.com.xendit.endpoint;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import ramdan.com.xendit.model.CardlessCreditCalculateParam;
import ramdan.com.xendit.model.CardlessCreditItem;
import ramdan.com.xendit.utils.ArrayBuilder;

public class CardlessCreditCalculateEndpointTest {

    @Test
    public void calculate() {
        val service = new CardlessCreditCalculateEndpoint();
        service.setUrl("https://api.xendit.co" + CardlessCreditCalculateEndpoint.ENDPOINT_PATH);

        val restTemplate = new RestTemplate();
        service.setTemplate(restTemplate);
        restTemplate.getInterceptors().add(Const.basicAuth);


        val balance = service.calculate(CardlessCreditCalculateParam.builder()
                .cardlessCreditType("KREDIVO")
                .amount(800000)
                .items(ArrayBuilder.as(
                        CardlessCreditItem.builder()
                                .id("123123")
                                .name("Phone Case")
                                .price(200000)
                                .type("Smartphone")
                                .url("http://example.com/phone/phone_case")
                                .quantity(2)
                                .build(),
                        CardlessCreditItem.builder()
                                .id("234567")
                                .name("Bluetooth Headset")
                                .price(400000)
                                .type("Audio")
                                .url("http://example.com/phone/bluetooth_headset")
                                .quantity(1)
                                .build()))

                .build());


        Assertions.assertNotNull(balance);
    }
}
