package br.com.unisinos.pareapp.controller;

import br.com.unisinos.pareapp.model.dto.ClassroomDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LandingPageController extends BaseController {

    @GetMapping({"/", ""})
    public ModelAndView landing(Model model) {
        model.addAttribute("joinClassroom", new ClassroomDto());
        return getView(model,"landing");
    }
}
