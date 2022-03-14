package br.com.unisinos.pareapp.service;

import br.com.unisinos.pareapp.client.backend.ClassroomBackEndClient;
import br.com.unisinos.pareapp.model.dto.ClassroomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassroomService {
    private final ClassroomBackEndClient classroomBackEndClient;

    public ClassroomDto getClassroom(Integer id) {
        return classroomBackEndClient.doGetById(id).getBody();
    }
}
