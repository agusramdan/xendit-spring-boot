package ramdan.com.xendit.spring.boot.demo;

import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;
import ramdan.com.xendit.endpoint.InvoiceCreateEndpoint;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	@Value("${ramdan.com.xendit.server.url:dddd}")
	private String serverUrl;
	@Value("${ramdan.com.xendit.server.auth.username}")
	private String serverUsername;

	@Bean
	public InvoiceCreateEndpoint invoiceCreateEndpoint(
			@Value("${ramdan.com.xendit.endpoint.invoice-create.url}")
			String url
	){
		val bean = new InvoiceCreateEndpoint();
		bean.setUrl(url);
		val template = restTemplate();
		template.getInterceptors().add(new BasicAuthenticationInterceptor(serverUsername,""));
		bean.setTemplate(template);
		return bean;
	}

}
