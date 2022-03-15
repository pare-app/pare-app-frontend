package br.com.unisinos.pareapp.service;

import br.com.unisinos.pareapp.client.backend.PairBackEndClient;
import br.com.unisinos.pareapp.client.backend.ProtectedBackEndClient;
import br.com.unisinos.pareapp.model.dto.entity.ClassroomDto;
import br.com.unisinos.pareapp.model.dto.entity.PairDto;
import br.com.unisinos.pareapp.model.dto.entity.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PairService extends AbstractEntityService<PairDto> {
    private final PairBackEndClient pairBackEndClient;
    private final HttpSessionService httpSessionService;

    @Override
    protected ProtectedBackEndClient<PairDto> getBackEndClient() {
        return pairBackEndClient;
    }

    public Optional<UserDto> getCompanionFromPair(PairDto pair) {
        Integer loggedUserId = httpSessionService.getLoggedUser().getId();
        if(pair.getStudent1().getId().equals(loggedUserId))
            return Optional.of(pair.getStudent2());
        if(pair.getStudent2().getId().equals(loggedUserId))
            return Optional.of(pair.getStudent1());
        return Optional.empty();
    }

    public Optional<PairDto> getPairFromClassroom(ClassroomDto classroomDto) {
        UserDto loggedUser = httpSessionService.getLoggedUser();
        return classroomDto.getPairs().stream()
                .filter(pair -> pair.getStudent1().getId().equals(loggedUser.getId())
                        ||  pair.getStudent2().getId().equals(loggedUser.getId()))
                .findFirst();
    }
}
