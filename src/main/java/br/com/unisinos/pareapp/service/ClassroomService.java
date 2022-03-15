package br.com.unisinos.pareapp.service;

import br.com.unisinos.pareapp.client.backend.ClassroomBackEndClient;
import br.com.unisinos.pareapp.client.backend.ProtectedBackEndClient;
import br.com.unisinos.pareapp.model.dto.entity.ClassroomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassroomService extends AbstractEntityService<ClassroomDto> {
    private final ClassroomBackEndClient classroomBackEndClient;

    @Override
    protected ProtectedBackEndClient<ClassroomDto> getBackEndClient() {
        return classroomBackEndClient;
    }
}
