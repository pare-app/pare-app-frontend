package br.com.unisinos.pareapp.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public abstract class AbstractBackEndClient <T,E> {
    private final String url = "http://localhost:8080";
    private final RestTemplate restTemplate;
    private final Class<E> responseType;

    public E doRequest(T requestDto){
        return restTemplate.postForObject(url + getPath(), getRequest(requestDto), getResponseType());
    }

    protected Class<E> getResponseType() {
        return responseType;
    }

    private String getPath() {
        return "/public/login";
    }

    private HttpEntity<T> getRequest(T requestDto) {
        return new HttpEntity<>(requestDto, getHeaders());
    }

    protected HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
