package ramdan.com.xendit.endpoint;

import lombok.Setter;
import lombok.val;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public abstract class AbstractEndpoint <T> {

    @Setter
    Class<T> responseType;
    @Setter
    String url;
    @Setter
    RestTemplate template;


    public AbstractEndpoint(Class<T> responseType) {
        this.responseType = responseType;
    }

    @Nullable
    public T getForObject(Object... uriVariables) throws RestClientException {
        return template.getForObject(url, responseType, uriVariables);
    }
    @Nullable
    public T getForObject(@NonNull HttpHeaders httpHeaders, Object... uriVariables) throws RestClientException {
        val httpEntity = new HttpEntity<>(httpHeaders);
        return template.exchange(url, HttpMethod.GET, httpEntity, responseType, uriVariables).getBody();
    }

    @Nullable
    public T getForObject(Map<String, ?> uriVariables) throws RestClientException {
        return template.getForObject(url, responseType, uriVariables);
    }
    @Nullable
    public T getForObjectParamQuery(Map<String, ?> queryParam) throws RestClientException {
        String url;
        if(queryParam!=null && !queryParam.isEmpty()) {
            val builder = UriComponentsBuilder.fromHttpUrl(this.url);
            queryParam.forEach(builder::queryParam);
            url=builder.build().toString();
        }else {
            url = this.url;
        }
        return template.getForObject(url, responseType);
    }
    @Nullable
    public ResponseEntity<T> getForEntity(Object... uriVariables) throws RestClientException {
        return template.getForEntity(url,responseType, uriVariables);
    }

    @Nullable
    public T postForObject(Object request,  Object... uriVariables) throws RestClientException {
        return template.postForObject(url, request, responseType, uriVariables);
    }

    @Nullable
    public T postForObject( Object request, Map<String, ?> uriVariables) throws RestClientException {
        return template.postForObject(url, request, responseType, uriVariables);
    }
    @Nullable
    public T postForObject(Object request, @NonNull HttpHeaders httpHeaders, Map<String, ?> uriVariables) throws RestClientException {
        val httpEntity = new HttpEntity<>(request,httpHeaders);
        return postForEntity(request,httpHeaders, responseType, uriVariables).getBody();
    }

    @Nullable
    public ResponseEntity<T> postForEntity(Object request, Object... uriVariables) throws RestClientException {
        return template.postForEntity(url, request, responseType, uriVariables);
    }
    @Nullable
    public T postForObject(Object request, @NonNull HttpHeaders httpHeaders, Object... uriVariables) throws RestClientException {
        return postForEntity(request,httpHeaders, responseType, uriVariables).getBody();
    }

    public ResponseEntity<T> postForEntity (Object request, Map<String, ?> uriVariables) throws RestClientException {
        return template.postForEntity(url, request, responseType, uriVariables);
    }

    @NonNull
    public ResponseEntity<T> postForEntity (Object request,@NonNull HttpHeaders httpHeaders, Map<String, ?> uriVariables) throws RestClientException {
        val httpEntity = new HttpEntity<>(request,httpHeaders);
        return template.exchange(url, HttpMethod.POST, httpEntity, responseType, uriVariables);
    }

    protected HttpHeaders newHttpHeadersForUserId(String userId){
        if(StringUtils.hasText(userId)) {
            return null;
        }
        val httpHeader = new HttpHeaders();
        httpHeader.add("for-user-id",userId);
        return httpHeader;
    }
}
