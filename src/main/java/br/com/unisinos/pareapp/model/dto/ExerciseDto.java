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
public class ExerciseDto {
    private Set<ClassroomDto> classrooms;
    private Set<QuestionDto> questions;
    private Set<SessionDto> sessions;
    private String description;
}
