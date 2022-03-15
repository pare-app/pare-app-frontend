package br.com.unisinos.pareapp.client.backend;

import br.com.unisinos.pareapp.model.dto.entity.QuestionDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QuestionBackEndClient extends ProtectedBackEndClient<QuestionDto> {
    @Value("${app.api.backend.path.question}")
    private String path;

    @Override
    protected Class<QuestionDto> getResponseType() {
        return QuestionDto.class;
    }

    @Override
    protected String getPath() {
        return path;
    }
}
