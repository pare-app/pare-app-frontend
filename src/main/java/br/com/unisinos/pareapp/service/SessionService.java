package br.com.unisinos.pareapp.service;

import br.com.unisinos.pareapp.client.backend.ClassroomBackEndClient;
import br.com.unisinos.pareapp.client.backend.SessionBackEndClient;
import br.com.unisinos.pareapp.model.dto.ClassroomDto;
import br.com.unisinos.pareapp.model.dto.SessionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionBackEndClient sessionBackEndClient;

    public SessionDto getSession(Integer id) {
        return sessionBackEndClient.doGetById(id).getBody();
    }
}
