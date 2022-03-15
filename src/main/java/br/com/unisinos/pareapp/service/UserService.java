package br.com.unisinos.pareapp.service;

import br.com.unisinos.pareapp.client.backend.LoginBackEndClient;
import br.com.unisinos.pareapp.client.backend.RegisterBackEndClient;
import br.com.unisinos.pareapp.model.dto.ConnectionDto;
import br.com.unisinos.pareapp.model.dto.entity.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final RegisterBackEndClient registerBackEndClient;
    private final LoginBackEndClient loginBackEndClient;
    private final HttpSessionService httpSessionService;

    public boolean authenticateBackEnd(UserDto loginDto){
        ConnectionDto response = loginBackEndClient.doPost(loginDto);
        if(response != null) {
            httpSessionService.setLoggedConnection(response);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void register(UserDto registerDto) {
        registerBackEndClient.doPost(registerDto);
    }
}
