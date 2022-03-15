package br.com.unisinos.pareapp.client.backend;

import br.com.unisinos.pareapp.model.dto.ConnectionDto;
import br.com.unisinos.pareapp.service.HttpSessionService;
import org.springframework.http.HttpHeaders;

import javax.annotation.Resource;

public abstract class ProtectedBackEndClient<T> extends AbstractBackEndClient<T,T> {
    @Resource
    private HttpSessionService httpSessionService;

    @Override
    protected HttpHeaders getHeaders() {
        HttpHeaders headers = super.getHeaders();
        ConnectionDto connection = (ConnectionDto) httpSessionService.getAttribute("connection");
        headers.setBearerAuth(connection.getToken());
        return headers;
    }
}
