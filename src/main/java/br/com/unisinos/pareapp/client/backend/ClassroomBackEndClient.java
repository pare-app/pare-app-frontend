package br.com.unisinos.pareapp.client.backend;

import br.com.unisinos.pareapp.client.backend.ProtectedBackEndClient;
import br.com.unisinos.pareapp.model.dto.ClassroomDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClassroomBackEndClient extends ProtectedBackEndClient<ClassroomDto, ClassroomDto> {
    @Value("${app.api.backend.path.classroom}")
    private String path;

    @Override
    protected Class<ClassroomDto> getResponseType() {
        return ClassroomDto.class;
    }

    @Override
    protected String getPath() {
        return path;
    }
}
