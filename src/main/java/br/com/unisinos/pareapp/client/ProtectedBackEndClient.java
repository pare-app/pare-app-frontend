package br.com.unisinos.pareapp.client;

import br.com.unisinos.pareapp.security.SessionData;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public abstract class ProtectedBackEndClient<T,E> extends AbstractBackEndClient<T,E> {
    private final SessionData sessionData;

    protected ProtectedBackEndClient(RestTemplate restTemplate,
                                     SessionData sessionData, Class<E> responseType) {
        super(restTemplate, responseType);
        this.sessionData = sessionData;
    }

    @Override
    protected HttpHeaders getHeaders() {
        HttpHeaders headers = super.getHeaders();
        headers.setBearerAuth(sessionData.getConnection().getToken());
        return headers;
    }
}
