package ramdan.com.xendit.endpoint;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import ramdan.com.xendit.model.CreditCardTokenParam;

import static ramdan.com.xendit.endpoint.CreditCardTokenCreateEndpoint.ENDPOINT_PATH;


public class CreditCardTokenCreateEndpointTest {

    @Test
    public void createCreditCardToken() {

        val service = new CreditCardTokenCreateEndpoint();
        service.setUrl("https://api.xendit.co" + ENDPOINT_PATH);

        val restTemplate = new RestTemplate();
        service.setTemplate(restTemplate);
        restTemplate.getInterceptors().add(Const.basicAuth);

        val balance = service.create(CreditCardTokenParam.builder()
                .amount("1233433")
                .cardData(new CreditCardTokenParam.CreditCardData("4000000000000002", "12", "2020", ""))
                .singleUse(true)
                .shouldAuthenticate(true)
                .build());

        Assertions.assertNotNull(balance);
    }
//
//    @Test
//    public void createCreditCardTokenMap(){
//        val service = new CreditCardTokenCreateEndpoint();
//        service.setUrl("https://api.xendit.co"+ENDPOINT_PATH);
//
//        val restTemplate= new RestTemplate();
//        service.setTemplate(restTemplate);
//        restTemplate.getInterceptors().add(Const.basicAuth );
//
//        val balance = service.create(MapBuilder.builder(String.class)
//                .put("external_id",UUID.randomUUID().toString())
//                .put("payer_email","agusramdan@gmail.com")
//                .put("description","Testing Bayar")
//                .put("amount",11000)
//                .build());
//
//        Assertions.assertNotNull(balance.getId());
//    }
//
//    @Test
//    public void createCreditCardTokenParam(){
//        val service = new CreditCardTokenCreateEndpoint();
//        service.setUrl("https://api.xendit.co"+ENDPOINT_PATH);
//
//        val restTemplate= new RestTemplate();
//        service.setTemplate(restTemplate);
//        restTemplate.getInterceptors().add(Const.basicAuth );
//
//        val balance = service.create(CreditCardTokenParam.builder()
//                .externalId(UUID.randomUUID().toString())
//                .payerEmail("agusramdan@gmail.com")
//                .description("Testing Bayar")
//                .amount(11000)
//                //.callbackVirtualAccountId("08529525279")
//                .fixedVa(true)
//                .build());
//
//        Assertions.assertNotNull(balance.getId());
//    }
}
