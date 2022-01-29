package br.com.unisinos.pareapp.controller;

import br.com.unisinos.pareapp.model.dto.user.ConnectionDto;
import br.com.unisinos.pareapp.service.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {
    private final SessionService sessionService;

    @GetMapping("/board")
    public String initBoard(Model model) {

        ConnectionDto connection = (ConnectionDto) sessionService.getAttribute("connection");
        model.addAttribute("username", connection.getUser().getUsername());
        return "board";
    }

}
