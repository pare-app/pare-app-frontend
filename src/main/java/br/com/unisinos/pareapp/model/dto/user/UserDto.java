package br.com.unisinos.pareapp.model.dto.user;

import br.com.unisinos.pareapp.model.dto.BaseDto;
import br.com.unisinos.pareapp.model.dto.ClassroomDto;
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
}
