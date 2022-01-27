package br.com.unisinos.pareapp.service;

import br.com.unisinos.pareapp.client.LoginBackEndClient;
import br.com.unisinos.pareapp.model.dto.user.ConnectionDto;
import br.com.unisinos.pareapp.model.dto.user.LoginDto;
import br.com.unisinos.pareapp.security.SessionData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginBackEndClient loginBackEndClient;
    private final SessionData sessionData;

    public Boolean authenticateBackEnd(LoginDto loginDto){
        ConnectionDto connectionDto = loginBackEndClient.doRequest(loginDto);
        if(connectionDto!=null) {
            ServletRequestAttributes attr = (ServletRequestAttributes)
                    RequestContextHolder.currentRequestAttributes();
            HttpSession session= attr.getRequest().getSession(true);
            session.setAttribute("connection", connectionDto);
            return Boolean.TRUE;
        }
        sessionData.setConnection(null);
        return Boolean.FALSE;
    }
}
