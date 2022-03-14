package br.com.unisinos.pareapp.model.dto;

import br.com.unisinos.pareapp.model.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PairDto {
    private ClassroomDto classroom;
    private UserDto student1;
    private UserDto student2;
}
