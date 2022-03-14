package br.com.unisinos.pareapp.client.backend;

import br.com.unisinos.pareapp.client.backend.AbstractBackEndClient;
import br.com.unisinos.pareapp.model.dto.user.ConnectionDto;
import br.com.unisinos.pareapp.model.dto.user.RegisterDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RegisterBackEndClient extends AbstractBackEndClient<RegisterDto, ConnectionDto> {
    @Value("${app.api.backend.path.register}")
    private String path;

    @Override
    protected Class<ConnectionDto> getResponseType() {
        return ConnectionDto.class;
    }

    @Override
    protected String getPath() {
        return path;
    }
}
