package br.com.unisinos.pareapp.service;

import br.com.unisinos.pareapp.client.backend.ProtectedBackEndClient;
import br.com.unisinos.pareapp.client.backend.QuestionBackEndClient;
import br.com.unisinos.pareapp.model.dto.entity.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService extends AbstractEntityService<QuestionDto> {
    private final QuestionBackEndClient questionBackEndClient;

    @Override
    protected ProtectedBackEndClient<QuestionDto> getBackEndClient() {
        return questionBackEndClient;
    }
}
