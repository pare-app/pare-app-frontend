package br.com.unisinos.pareapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class BoardPageController extends BaseController {

    @GetMapping("/board")
    public ModelAndView initBoard(Model model) {
        return getView(model,"board");
    }
}
