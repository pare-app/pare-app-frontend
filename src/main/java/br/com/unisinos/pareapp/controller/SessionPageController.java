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

import java.util.List;
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
        return getView(model,"redirect:" + gerRedirectionPath(exerciseId, pairId));
    }

    private String gerRedirectionPath(Integer exerciseId, Integer pairId) {
        return UriComponentsBuilder.fromPath("/session/" + exerciseId + "/" + pairId + "/0")
                .encode()
                .toUriString();
    }

    @GetMapping({"/{exerciseId}/{pairId}/{questionIndex}"})
    public ModelAndView sessionBoard(Model model,
                                @PathVariable(name = "exerciseId") Integer exerciseId,
                                @PathVariable(name = "pairId") Integer pairId,
                                @PathVariable(name = "questionIndex") Integer questionIndex) {
        SessionDto sessionDto = sessionService.getSessionByUniqueKey(exerciseId,pairId);
        List<QuestionDto> questionDtos = exerciseService.doGetQuestions(exerciseId);

        model.addAttribute("exerciseId", exerciseId);
        model.addAttribute("pairId", pairId);
        model.addAttribute("totalQuestions", questionDtos.size());
        model.addAttribute("currentQuestionIndex", questionIndex);
        model.addAttribute("question", questionDtos.get(questionIndex));
        model.addAttribute("sessionDto", sessionDto);
        return getView(model,"session");
    }

}
