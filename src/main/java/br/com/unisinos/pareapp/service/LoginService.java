package br.com.unisinos.pareapp.service;

import br.com.unisinos.pareapp.client.backend.LoginBackEndClient;
import br.com.unisinos.pareapp.model.dto.user.ConnectionDto;
import br.com.unisinos.pareapp.model.dto.user.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginBackEndClient loginBackEndClient;
    private final HttpSessionService httpSessionService;

    public boolean authenticateBackEnd(LoginDto loginDto){
        ConnectionDto response = loginBackEndClient.doPost(loginDto);
        if(response != null) {
            httpSessionService.setLoggedConnection(response);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
