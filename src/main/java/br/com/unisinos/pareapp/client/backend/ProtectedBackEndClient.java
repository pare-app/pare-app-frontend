package br.com.unisinos.pareapp.client.backend;

import br.com.unisinos.pareapp.model.dto.user.ConnectionDto;
import br.com.unisinos.pareapp.service.SessionService;
import org.springframework.http.HttpHeaders;

import javax.annotation.Resource;

public abstract class ProtectedBackEndClient<T,E> extends AbstractBackEndClient<T,E> {
    @Resource
    private SessionService sessionService;

    @Override
    protected HttpHeaders getHeaders() {
        HttpHeaders headers = super.getHeaders();
        ConnectionDto connection = (ConnectionDto) sessionService.getAttribute("connection");
        headers.setBearerAuth(connection.getToken());
        return headers;
    }
}
