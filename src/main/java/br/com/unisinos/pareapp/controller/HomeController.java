package br.com.unisinos.pareapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Controller
@RequestMapping(value ={"/",})
@RequiredArgsConstructor
public class HomeController {
    private final RestTemplate restTemplate;

    @Value("${messages.home:default-value}")
    private String message = "Hello World";

    @GetMapping({"/", "home"})
    public String welcome(Model model) {
        log.info("Spring Boot Thymeleaf Configuration Example");
        model.addAttribute("message", message);
        return "home";
    }

    @GetMapping("/hit")
    public String hit(Model model) {
        log.info("hits");
        String greeting = restTemplate.getForObject(
                "http://localhost:8080/greeting", String.class);
        log.info(greeting.toString());

        model.addAttribute("message", message);
        return "home";
    }
}
