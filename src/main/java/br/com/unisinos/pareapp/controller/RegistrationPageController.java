package br.com.unisinos.pareapp.controller;

import br.com.unisinos.pareapp.model.dto.entity.UserDto;
import br.com.unisinos.pareapp.service.UserService;
import br.com.unisinos.pareapp.service.HttpSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RegistrationPageController {
    private final HttpSessionService httpSessionService;
    private final UserService userService;

    @GetMapping({"/login"})
    public String login(Model model) {
        if(httpSessionService.isLogged()) return "redirect:";

        model.addAttribute("loginDto", new UserDto());
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        if(httpSessionService.isLogged()) return "redirect:";

        model.addAttribute("registerDto", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String performRegistration(@ModelAttribute(name = "registerDto") UserDto registerDto) {
        userService.register(registerDto);

        return "redirect: login";
    }
}
