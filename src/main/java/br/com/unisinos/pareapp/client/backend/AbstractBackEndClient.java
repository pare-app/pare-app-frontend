package br.com.unisinos.pareapp.client.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

public abstract class AbstractBackEndClient <T,E> {
    @Resource
    private RestTemplate restTemplate;

    @Value("${app.api.backend.url}")
    private String url;

    public E doRequest(T requestDto){
        return restTemplate.postForObject(url + getPath(), getRequest(requestDto), getResponseType());
    }

    protected abstract Class<E> getResponseType();

    protected abstract String getPath();

    private HttpEntity<T> getRequest(T requestDto) {
        return new HttpEntity<>(requestDto, getHeaders());
    }

    protected HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
