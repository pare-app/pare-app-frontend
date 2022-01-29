package br.com.unisinos.pareapp.client.backend;

import br.com.unisinos.pareapp.model.dto.user.ConnectionDto;
import br.com.unisinos.pareapp.model.dto.user.RegisterDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RegisterBackEndClient extends PublicBackEndClient<RegisterDto, ConnectionDto>{
    protected RegisterBackEndClient(RestTemplate restTemplate) {
        super(restTemplate, ConnectionDto.class);
        setPath("/public/register");
    }

}
