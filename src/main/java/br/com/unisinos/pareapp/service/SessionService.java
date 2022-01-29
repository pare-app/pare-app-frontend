package br.com.unisinos.pareapp.service;

import br.com.unisinos.pareapp.model.dto.user.ConnectionDto;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Service
public class SessionService {
    public Object getAttribute(String name) {
        return getSession().getAttribute(name);
    }

    public void setAttribute(String name, Object value) {
        getSession().setAttribute(name, value);
    }

    public HttpSession getSession() {
        ServletRequestAttributes attr = (ServletRequestAttributes)
                RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true);
    }

    public boolean isLogged() {
        ConnectionDto connection = (ConnectionDto) getAttribute("connection");
        return connection != null && !isEmpty(connection.getToken());
    }
}
