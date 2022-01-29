package br.com.unisinos.pareapp.client.backend;

import org.springframework.web.client.RestTemplate;

public abstract class PublicBackEndClient<T,E> extends AbstractBackEndClient<T,E> {
    protected PublicBackEndClient(RestTemplate restTemplate, Class<E> responseType) {
        super(restTemplate, responseType);
    }
}
