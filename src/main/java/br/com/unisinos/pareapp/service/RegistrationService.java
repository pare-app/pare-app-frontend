package br.com.unisinos.pareapp.service;

import br.com.unisinos.pareapp.client.backend.RegisterBackEndClient;
import br.com.unisinos.pareapp.model.dto.user.RegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final RegisterBackEndClient registerBackEndClient;

    public void register(RegisterDto registerDto) {
        registerBackEndClient.doRequest(registerDto);
    }
}
