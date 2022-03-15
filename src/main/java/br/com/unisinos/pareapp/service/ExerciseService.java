package br.com.unisinos.pareapp.service;

import br.com.unisinos.pareapp.client.backend.ExerciseBackEndClient;
import br.com.unisinos.pareapp.client.backend.ProtectedBackEndClient;
import br.com.unisinos.pareapp.model.dto.entity.ExerciseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseService extends AbstractEntityService<ExerciseDto>{
    private final ExerciseBackEndClient exerciseBackEndClient;

    @Override
    protected ProtectedBackEndClient<ExerciseDto> getBackEndClient() {
        return exerciseBackEndClient;
    }
}
