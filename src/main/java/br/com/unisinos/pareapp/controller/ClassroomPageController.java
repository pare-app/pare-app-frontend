package br.com.unisinos.pareapp.controller;

import br.com.unisinos.pareapp.model.dto.ClassroomDto;
import br.com.unisinos.pareapp.model.dto.PairDto;
import br.com.unisinos.pareapp.model.dto.user.UserDto;
import br.com.unisinos.pareapp.service.ClassroomService;
import br.com.unisinos.pareapp.service.HttpSessionService;
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
@RequestMapping("/classroom")
public class ClassroomPageController extends BaseController {
    private final ClassroomService classroomService;
    private final HttpSessionService httpSessionService;

    @GetMapping({"/{id}"})
    public ModelAndView classroom(Model model, @PathVariable(name = "id") Integer id) {
        ClassroomDto classroomDto = classroomService.getClassroom(id);
        UserDto loggedUser = httpSessionService.getLoggedUser();

        PairDto pairDto = classroomDto.getPairs().stream()
                .filter(pair -> pair.getStudent1().getId().equals(loggedUser.getId())
                        ||  pair.getStudent2().getId().equals(loggedUser.getId()))
                .findFirst().orElse(null);

        model.addAttribute("pair", pairDto);
        model.addAttribute("classroom", classroomDto);
        return getView(model,"classroom");
    }

    @GetMapping({"/join"})
    public ModelAndView join(Model model, @ModelAttribute(name = "joinClassroom") ClassroomDto joinClassroomDto) {

        return getView(model,"landing");
    }
}
