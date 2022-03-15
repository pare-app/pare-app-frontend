package br.com.unisinos.pareapp.model.dto.entity;

import br.com.unisinos.pareapp.model.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto extends BaseDto {
    private SessionDto session;
    private QuestionDto question;
    private byte[] image;
}
