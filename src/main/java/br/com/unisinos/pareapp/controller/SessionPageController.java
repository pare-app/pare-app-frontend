package br.com.unisinos.pareapp.controller;

import br.com.unisinos.pareapp.model.dto.ClassroomDto;
import br.com.unisinos.pareapp.model.dto.PairDto;
import br.com.unisinos.pareapp.model.dto.SessionDto;
import br.com.unisinos.pareapp.model.dto.user.UserDto;
import br.com.unisinos.pareapp.service.ClassroomService;
import br.com.unisinos.pareapp.service.HttpSessionService;
import br.com.unisinos.pareapp.service.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/session")
public class SessionPageController extends BaseController {
    private final SessionService sessionService;
    private final HttpSessionService httpSessionService;

    @GetMapping({"/{exerciseId}/{pairId}"})
    public ModelAndView session(Model model,
                                @PathVariable(name = "exerciseId") Integer exerciseId,
                                @PathVariable(name = "pairId") Integer pairId) {
        //SessionDto sessionDto = sessionService.getSession(exerciseId);

        //model.addAttribute("session", sessionDto);
        return getView(model,"session");
    }
}
