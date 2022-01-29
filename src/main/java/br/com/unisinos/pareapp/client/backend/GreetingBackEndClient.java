package br.com.unisinos.pareapp.client.backend;

import br.com.unisinos.pareapp.model.dto.GreetingDto;
import br.com.unisinos.pareapp.service.SessionService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GreetingBackEndClient extends ProtectedBackEndClient<GreetingDto,GreetingDto>{
    protected GreetingBackEndClient(RestTemplate restTemplate, SessionService sessionService) {
        super(restTemplate, sessionService, GreetingDto.class);
        setPath("/greeting");
    }
}
