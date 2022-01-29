package br.com.unisinos.pareapp.controller;

import br.com.unisinos.pareapp.client.backend.GreetingBackEndClient;
import br.com.unisinos.pareapp.model.dto.GreetingDto;
import br.com.unisinos.pareapp.model.dto.user.ConnectionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingBackEndClient greetingBackEndClient;

    @GetMapping("/greeting")
    public String greetingForm(Model model, HttpSession session) {
        model.addAttribute("greeting", new GreetingDto());
        ConnectionDto connection = (ConnectionDto) session.getAttribute("connection");
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute(name = "greeting") GreetingDto greetingDto, Model model) {
        try {
            GreetingDto result = greetingBackEndClient.doRequest(greetingDto);
            log.info(String.format("sent - %s", greetingDto != null ? greetingDto.toString() : "NULL"));
            log.info(String.format("received - %s", result != null ? result.toString() : "NULL"));
            model.addAttribute("greetingDto", result);
            return "result";
        } catch (Exception e) {
            return "error";
        }
    }

}
