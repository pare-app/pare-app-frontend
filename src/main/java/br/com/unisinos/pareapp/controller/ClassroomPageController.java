package br.com.unisinos.pareapp.controller;

import br.com.unisinos.pareapp.model.dto.entity.ClassroomDto;
import br.com.unisinos.pareapp.model.dto.entity.PairDto;
import br.com.unisinos.pareapp.model.dto.entity.UserDto;
import br.com.unisinos.pareapp.service.ClassroomService;
import br.com.unisinos.pareapp.service.HttpSessionService;
import br.com.unisinos.pareapp.service.PairService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/classroom")
public class ClassroomPageController extends BaseController {
    private final ClassroomService classroomService;
    private final PairService pairService;

    @GetMapping({"/{id}"})
    public ModelAndView classroom(Model model, @PathVariable(name = "id") Integer id) {
        ClassroomDto classroomDto = classroomService.get(id);

        PairDto pairDto = pairService.getPairFromClassroom(classroomDto).orElse(new PairDto());

        UserDto companion = pairService.getCompanionFromPair(pairDto)
                .orElse(new UserDto());

        model.addAttribute("companion", companion);
        model.addAttribute("pair", pairDto);
        model.addAttribute("classroom", classroomDto);
        return getView(model,"classroom");
    }

    @GetMapping({"/join"})
    public ModelAndView join(Model model, @ModelAttribute(name = "joinClassroom") ClassroomDto joinClassroomDto) {

        return getView(model,"landing");
    }
}
