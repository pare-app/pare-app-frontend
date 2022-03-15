package br.com.unisinos.pareapp.client.backend;

import br.com.unisinos.pareapp.model.dto.ConnectionDto;
import br.com.unisinos.pareapp.model.dto.entity.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginBackEndClient extends AbstractBackEndClient<UserDto, ConnectionDto> {
    @Value("${app.api.backend.path.login}")
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
