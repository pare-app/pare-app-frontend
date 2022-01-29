package br.com.unisinos.pareapp.client.backend;

import br.com.unisinos.pareapp.model.dto.user.ConnectionDto;
import br.com.unisinos.pareapp.service.SessionService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public abstract class ProtectedBackEndClient<T,E> extends AbstractBackEndClient<T,E> {
    private final SessionService sessionService;

    protected ProtectedBackEndClient(RestTemplate restTemplate, SessionService sessionService, Class<E> responseType) {
        super(restTemplate, responseType);
        this.sessionService = sessionService;
    }

    @Override
    protected HttpHeaders getHeaders() {
        HttpHeaders headers = super.getHeaders();
        ConnectionDto connection = (ConnectionDto) sessionService.getAttribute("connection");
        headers.setBearerAuth(connection.getToken());
        return headers;
    }
}
