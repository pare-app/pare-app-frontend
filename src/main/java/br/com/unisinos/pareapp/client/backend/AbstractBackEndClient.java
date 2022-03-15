package br.com.unisinos.pareapp.client.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

public abstract class AbstractBackEndClient <T,E> {
    @Resource
    private RestTemplate restTemplate;

    @Value("${app.api.backend.url}")
    private String url;

    public E doPost(T requestDto){
        return restTemplate.postForObject(url + getPath(), getHttpEntity(requestDto), getResponseType());
    }

    public ResponseEntity<E> doGetById(Integer id){
        return restTemplate.exchange(url + getPath() + "/" + id, HttpMethod.GET, getHttpEntity(), getResponseType());
    }

    protected abstract Class<E> getResponseType();

    protected abstract String getPath();

    protected HttpEntity<T> getHttpEntity(T requestDto) {
        return new HttpEntity<>(requestDto, getHeaders());
    }

    protected HttpEntity<T> getHttpEntity() {
        return new HttpEntity<>(getHeaders());
    }

    protected HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public String getUrl() {
        return url;
    }
}
