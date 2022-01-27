package br.com.unisinos.pareapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/board")
public class BoardController {

    @GetMapping("")
    public String initBoard(Model model) {
        return "board";
    }

    @GetMapping("whiteboard")
    public String initWhiteBoard(Model model) {
        return "whiteboard";
    }
}
