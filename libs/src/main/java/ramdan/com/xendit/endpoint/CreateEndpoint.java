package ramdan.com.xendit.endpoint;

import lombok.val;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;
import ramdan.com.xendit.model.InvoiceParam;

import java.util.Map;

/**
 * Create invoice with all parameters as HashMap
 * listed here https://xendit.github.io/apireference/#create-invoice.
 */
public class CreateEndpoint<T> extends AbstractEndpoint<T> {

    public CreateEndpoint(Class<T> responseType) {
        super(responseType);
    }

    public T create(Object invoice) {
        return create(invoice, (HttpHeaders) null);
    }

    public T create(Map<String, Object> invoice) {
        return create(invoice, (HttpHeaders) null);
    }

    public T create(InvoiceParam invoice) {

        return create(invoice, (HttpHeaders) null);
    }

    public T create(Object invoice, String userId) {
        HttpHeaders httpHeader = null;
        if (StringUtils.hasText(userId)) {
            httpHeader = new HttpHeaders();
            httpHeader.add("for-user-id", userId);
        }
        return create(invoice, httpHeader);
    }

    public T create(Object invoice, HttpHeaders httpHeader) {

        if (httpHeader != null) {
            val httpEntity = new HttpEntity(invoice, httpHeader);
            val response = super.template.exchange(url, HttpMethod.POST, httpEntity, responseType);
            return response.getBody();
        } else {
            return super.postForObject(invoice);
        }
    }


}
