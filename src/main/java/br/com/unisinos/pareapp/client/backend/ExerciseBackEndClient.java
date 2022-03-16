package br.com.unisinos.pareapp.client.backend;

import br.com.unisinos.pareapp.model.dto.entity.ExerciseDto;
import br.com.unisinos.pareapp.model.dto.entity.QuestionDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<QuestionDto[]> doGetQuestions(Integer id){
        return getRestTemplate().exchange(getUrl() + getPath() + "/questions/" + id, HttpMethod.GET, getHttpEntity(), QuestionDto[].class);
    }
}
