package br.com.unisinos.pareapp.model.dto;

import br.com.unisinos.pareapp.model.dto.entity.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionDto {
    private UserDto user;
    private String token;
}
