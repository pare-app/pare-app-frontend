package br.com.unisinos.pareapp.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value ={"/",})
@RequiredArgsConstructor
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    private final RestTemplate restTemplate;

    @Value("${messages.home:default-value}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Model model) {
        log.info("Spring Boot Thymeleaf Configuration Example");
        model.addAttribute("message", message);
        return "home";
    }

    @RequestMapping("/hit")
    public String hit(Model model) {
        log.info("hits");
        String greeting = restTemplate.getForObject(
                "http://localhost:8080/greeting", String.class);
        log.info(greeting.toString());

        model.addAttribute("message", message);
        return "home";
    }
}