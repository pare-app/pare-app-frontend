package br.com.unisinos.pareapp.service;

import br.com.unisinos.pareapp.client.backend.SessionBackEndClient;
import br.com.unisinos.pareapp.model.dto.entity.SessionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionBackEndClient sessionBackEndClient;

    public SessionDto getSessionByUniqueKey(Integer exerciseId, Integer pairId) {
        return sessionBackEndClient.doGetByUniqueKey(exerciseId, pairId).getBody();
    }
}
