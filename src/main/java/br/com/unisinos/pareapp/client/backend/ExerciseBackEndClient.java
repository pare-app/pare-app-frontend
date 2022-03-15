package br.com.unisinos.pareapp.client.backend;

import br.com.unisinos.pareapp.model.dto.entity.ExerciseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExerciseBackEndClient extends ProtectedBackEndClient<ExerciseDto> {
    @Value("${app.api.backend.path.exercise}")
    private String path;

    @Override
    protected Class<ExerciseDto> getResponseType() {
        return ExerciseDto.class;
    }

    @Override
    protected String getPath() {
        return path;
    }
}
