package ramdan.com.xendit.endpoint;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import ramdan.com.xendit.model.CardlessCreditCustomer;
import ramdan.com.xendit.model.CardlessCreditItem;
import ramdan.com.xendit.model.CardlessCreditParam;
import ramdan.com.xendit.model.CardlessCreditShippingAddress;
import ramdan.com.xendit.utils.ArrayBuilder;

public class CardlessCreditCreateEndpointTest {

    @Test
    public void create() {
        val service = new CardlessCreditCreateEndpoint();
        service.setUrl("https://api.xendit.co" + CardlessCreditCreateEndpoint.ENDPOINT_PATH);

        val restTemplate = new RestTemplate();
        service.setTemplate(restTemplate);
        restTemplate.getInterceptors().add(Const.basicAuth);


        val balance = service.create(CardlessCreditParam.builder()
                .cardlessCreditType("KREDIVO")
                .externalId("test-cardless-credit-01")
                .amount(800000)
                .paymentType(CardlessCreditParam.PaymentType.THREE_MONTHS)
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
                .customerDetails(CardlessCreditCustomer.builder()
                        .firstName("customer first name")
                        .lastName("customer last name")
                        .email("customer@yourwebsite.com")
                        .phone("081513114262")
                        .build())
                .shippingAddress(CardlessCreditShippingAddress.builder()
                        .firstName("first name")
                        .lastName("last name")
                        .address("Jalan Teknologi No. 12")
                        .city("Jakarta")
                        .postalCode("12345")
                        .phone("081513114262")
                        .countryCode("IDN")
                        .build())
                .redirectUrl("http://example.com")
                .callbackUrl("http://example.com/callback-cardless-credit")
                .build());


        Assertions.assertNotNull(balance);
    }
}
