package br.com.unisinos.pareapp.controller;

import br.com.unisinos.pareapp.Greeting;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequiredArgsConstructor
public class GreetingController {
    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    private final RestTemplate restTemplate;

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute(name = "greeting") Greeting greeting, Model model) {
        try {
            Greeting result = restTemplate.postForObject(
                    "http://localhost:8080/greeting?id=" + greeting.getId() + "&message=" + greeting.getContent(),
                    null, Greeting.class);
            log.info(String.format("sent - %s", greeting != null ? greeting.toString() : "NULL"));
            log.info(String.format("received - %s", result != null ? result.toString() : "NULL"));
            model.addAttribute("greeting", result);
            return "result";
        } catch (Exception e) {
            return "error";
        }
    }

}
