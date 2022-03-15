package br.com.unisinos.pareapp.controller;

import br.com.unisinos.pareapp.model.dto.entity.*;
import br.com.unisinos.pareapp.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/session")
public class SessionPageController extends BaseController {
    private final SessionService sessionService;
    private final ExerciseService exerciseService;
    private final QuestionService questionService;
    private final PairService pairService;

    @GetMapping({"/{exerciseId}/{pairId}"})
    public ModelAndView session(Model model,
                                @PathVariable(name = "exerciseId") Integer exerciseId,
                                @PathVariable(name = "pairId") Integer pairId) {
        ExerciseDto exerciseDto = exerciseService.get(exerciseId);
        QuestionDto firstQuestionDto = exerciseDto.getQuestions().stream().findFirst().orElse(new QuestionDto());

        return getView(model,"redirect:" + gerRedirectionPath(exerciseId, pairId, firstQuestionDto));
    }

    private String gerRedirectionPath(Integer exerciseId, Integer pairId, QuestionDto firstQuestionDto) {
        return UriComponentsBuilder.fromPath("/session/" + exerciseId + "/" + pairId + "/" + firstQuestionDto.getId())
                .encode()
                .toUriString();
    }

    @GetMapping({"/{exerciseId}/{pairId}/{questionId}"})
    public ModelAndView sessionBoard(Model model,
                                @PathVariable(name = "exerciseId") Integer exerciseId,
                                @PathVariable(name = "pairId") Integer pairId,
                                @PathVariable(name = "questionId") Integer questionId) {
        SessionDto sessionDto = sessionService.getSessionByUniqueKey(exerciseId,pairId);
        ExerciseDto exerciseDto = exerciseService.get(exerciseId);
        QuestionDto questionDto = questionService.get(questionId);
        PairDto pairDto = pairService.get(pairId);
        UserDto companion = pairService.getCompanionFromPair(pairDto).orElse(new UserDto());

        model.addAttribute("question", questionDto);
        model.addAttribute("companion", companion);
        model.addAttribute("pair", pairDto);
        model.addAttribute("exercise", exerciseDto);
        model.addAttribute("session", sessionDto);
        return getView(model,"session");
    }

}
