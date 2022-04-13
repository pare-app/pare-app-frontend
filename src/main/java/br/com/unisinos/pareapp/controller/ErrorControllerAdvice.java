package br.com.unisinos.pareapp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(HttpClientErrorException.class)
    public ModelAndView httpClientError(HttpClientErrorException ex, Model model) {
        model.addAttribute("httpStatusCode", ex.getStatusCode().value());
        return new ModelAndView("redirect:/error", model.asMap());
    }
}
