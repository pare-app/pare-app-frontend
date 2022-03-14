package br.com.unisinos.pareapp.service;

import br.com.unisinos.pareapp.model.dto.user.ConnectionDto;
import br.com.unisinos.pareapp.model.dto.user.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Service
public class HttpSessionService {

    protected static final String LOGGED_CONNECTION = "connection";

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
        ConnectionDto connection = getLoggedConnection();
        return connection != null && !isEmpty(connection.getToken());
    }

    private ConnectionDto getLoggedConnection() {
        return (ConnectionDto) getAttribute(LOGGED_CONNECTION);
    }

    public UserDto getLoggedUser() {
        return getLoggedConnection().getUser();
    }

    public void setLoggedConnection(ConnectionDto connection) {
        setAttribute(LOGGED_CONNECTION, connection);
    }
}
