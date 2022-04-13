package br.com.unisinos.pareapp.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DefaultErrorController extends BaseController implements ErrorController {

    @GetMapping(value = "/error")
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest, Model model,
                                        @RequestParam(value = "httpStatusCode", required = false) Integer httpStatusCode) {
        String errorMsg = "";
        if(httpStatusCode == null) httpStatusCode = getErrorCode(httpRequest);

        switch (httpStatusCode) {
            case 400: {
                errorMsg = "Parâmetros inválidos";
                break;
            }
            case 401: {
                errorMsg = "Página não autorizada!";
                break;
            }
            case 404: {
                errorMsg = "Página não encontrada!";
                break;
            }
            case 500: {
                errorMsg = "Erro no sistema";
                break;
            }
            default: {
                errorMsg = "Erro desconhecido";
            }
        }
        model.addAttribute("errorMsg", errorMsg);
        return getView(model,"error");
    }

    private Integer getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }
}