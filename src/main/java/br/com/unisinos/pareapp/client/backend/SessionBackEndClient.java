package br.com.unisinos.pareapp.client.backend;

import br.com.unisinos.pareapp.model.dto.SessionDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SessionBackEndClient extends ProtectedBackEndClient<SessionDto, SessionDto> {
    @Value("${app.api.backend.path.session}")
    private String path;

    @Override
    protected Class<SessionDto> getResponseType() {
        return SessionDto.class;
    }

    @Override
    protected String getPath() {
        return path;
    }
}
