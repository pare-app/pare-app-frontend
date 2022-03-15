package br.com.unisinos.pareapp.controller;

import br.com.unisinos.pareapp.model.dto.entity.ExerciseDto;
import br.com.unisinos.pareapp.model.dto.entity.PairDto;
import br.com.unisinos.pareapp.model.dto.entity.SessionDto;
import br.com.unisinos.pareapp.model.dto.entity.UserDto;
import br.com.unisinos.pareapp.service.ExerciseService;
import br.com.unisinos.pareapp.service.HttpSessionService;
import br.com.unisinos.pareapp.service.PairService;
import br.com.unisinos.pareapp.service.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/session")
public class SessionPageController extends BaseController {
    private final SessionService sessionService;
    private final ExerciseService exerciseService;
    private final PairService pairService;

    @GetMapping({"/{exerciseId}/{pairId}"})
    public ModelAndView session(Model model,
                                @PathVariable(name = "exerciseId") Integer exerciseId,
                                @PathVariable(name = "pairId") Integer pairId) {
        SessionDto sessionDto = sessionService.getSessionByUniqueKey(exerciseId,pairId);
        ExerciseDto exerciseDto = exerciseService.get(exerciseId);
        PairDto pairDto = pairService.get(pairId);
        UserDto companion = pairService.getCompanionFromPair(pairDto).orElse(new UserDto());

        model.addAttribute("companion", companion);
        model.addAttribute("pair", pairDto);
        model.addAttribute("exercise", exerciseDto);
        model.addAttribute("session", sessionDto);
        return getView(model,"session");
    }
}
