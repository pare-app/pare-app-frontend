package br.com.unisinos.pareapp.client.backend;

import br.com.unisinos.pareapp.model.dto.user.ConnectionDto;
import br.com.unisinos.pareapp.model.dto.user.LoginDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LoginBackEndClient extends PublicBackEndClient<LoginDto,ConnectionDto> {
    public LoginBackEndClient(RestTemplate restTemplate) {
        super(restTemplate, ConnectionDto.class);
        setPath("/public/login");
    }
}
