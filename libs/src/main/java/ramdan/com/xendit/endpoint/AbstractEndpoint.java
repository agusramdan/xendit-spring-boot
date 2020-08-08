package ramdan.com.xendit.endpoint;

import lombok.Setter;
import lombok.val;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<T> postForEntity(Object request, Object... uriVariables) throws RestClientException {
        return template.postForEntity(url, request, responseType, uriVariables);
    }

    public ResponseEntity<T> postForEntity (Object request, Map<String, ?> uriVariables) throws RestClientException {
        return template.postForEntity(url, request, responseType, uriVariables);
    }





//    //    public  ResponseEntity<T> getFor(){
////        return template.getForEntity()
////    }
//    protected <T> HttpEntity<T> createHttpRequest(Map<String,String> header, T entity){
//        val headers = new HttpHeaders();
//        if(header!=null) {
//            headers.setAll(header);
//        }
//        if(!headers.containsKey("Accept")) {
//            headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//        }
//        return new HttpEntity<T>(entity,headers);
//    }
//
//    protected <T> HttpEntity<T> createHttpRequest(T entity){
//        return createHttpRequest(null,entity);
//    }
//
//    protected  HttpEntity createHttpRequest(Map header){
//        return createHttpRequest(header,null);
//    }
}
