package br.com.unisinos.pareapp.model.dto.entity;

import br.com.unisinos.pareapp.model.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionDto extends BaseDto {
    private ExerciseDto exercise;
    private PairDto pair;
    private Set<AnswerDto> answers;
}
