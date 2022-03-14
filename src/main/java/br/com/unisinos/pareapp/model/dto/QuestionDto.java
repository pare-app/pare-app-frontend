package br.com.unisinos.pareapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto extends BaseDto{
    private String description;
    private byte[] image;
    private Set<ExerciseDto> exercises;
    private SolutionDto solution;
}
