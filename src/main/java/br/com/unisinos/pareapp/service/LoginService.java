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
    private final SessionService sessionService;

    public boolean authenticateBackEnd(LoginDto loginDto){
        ConnectionDto response = loginBackEndClient.doRequest(loginDto);
        if(response != null) {
            sessionService.setAttribute("connection", response);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
