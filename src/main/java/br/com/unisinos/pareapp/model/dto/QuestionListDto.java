package br.com.unisinos.pareapp.model.dto;

import br.com.unisinos.pareapp.model.dto.entity.QuestionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionListDto {
    private List<QuestionDto> questions;
}
