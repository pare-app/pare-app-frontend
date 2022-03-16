package br.com.unisinos.pareapp.service;

import br.com.unisinos.pareapp.client.backend.ExerciseBackEndClient;
import br.com.unisinos.pareapp.client.backend.ProtectedBackEndClient;
import br.com.unisinos.pareapp.model.dto.QuestionListDto;
import br.com.unisinos.pareapp.model.dto.entity.ExerciseDto;
import br.com.unisinos.pareapp.model.dto.entity.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService extends AbstractEntityService<ExerciseDto>{
    private final ExerciseBackEndClient exerciseBackEndClient;

    @Override
    protected ProtectedBackEndClient<ExerciseDto> getBackEndClient() {
        return exerciseBackEndClient;
    }

    public List<QuestionDto> doGetQuestions(Integer id) {
        QuestionDto[] questionsArray = exerciseBackEndClient.doGetQuestions(id).getBody();
        if(questionsArray == null) return Collections.emptyList();
        return Arrays.asList(questionsArray);
    }
}
