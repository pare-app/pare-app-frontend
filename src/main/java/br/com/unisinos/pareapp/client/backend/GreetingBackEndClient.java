package br.com.unisinos.pareapp.client.backend;

import br.com.unisinos.pareapp.model.dto.GreetingDto;
import br.com.unisinos.pareapp.service.SessionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GreetingBackEndClient extends ProtectedBackEndClient<GreetingDto,GreetingDto>{
    @Value("${app.api.backend.path.greeting}")
    private String path;

    @Override
    protected Class<GreetingDto> getResponseType() {
        return GreetingDto.class;
    }

    @Override
    protected String getPath() {
        return path;
    }
}
