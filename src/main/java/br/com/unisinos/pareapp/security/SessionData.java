package br.com.unisinos.pareapp.security;

import br.com.unisinos.pareapp.model.dto.user.ConnectionDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SessionData {
    private ConnectionDto connection;
}
