package br.com.unisinos.pareapp.controller;

import br.com.unisinos.pareapp.model.dto.user.ConnectionDto;
import br.com.unisinos.pareapp.model.dto.user.UserDto;
import br.com.unisinos.pareapp.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

public abstract class BaseController {
    @Resource
    private SessionService sessionService;

    protected ModelAndView getView(Model model, String path){
        UserDto userDto = getLoggedUser();

        if (userDto!=null) {
            model.addAttribute("logged_user", userDto);
        }
        return (new ModelAndView(path,model.asMap()));
    }

    protected UserDto getLoggedUser(){
        ConnectionDto connection = (ConnectionDto) sessionService.getAttribute("connection");
        if(connection == null) return null;

        return connection.getUser();
    }
}
