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
public class ClassroomDto extends BaseDto {
    private String name;
    private UserDto owner;;
    private Set<UserDto> students;
    private Set<ExerciseDto> exercises;
    private Set<PairDto> pairs;
}
