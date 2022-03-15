package br.com.unisinos.pareapp.model.dto.entity;

import br.com.unisinos.pareapp.model.dto.BaseDto;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto extends BaseDto {
    private String name;
    private String username;
    private Set<ClassroomDto> classrooms;
    private String password;
}
