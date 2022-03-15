package br.com.unisinos.pareapp.client.backend;

import br.com.unisinos.pareapp.model.dto.entity.SessionDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;

@Component
public class SessionBackEndClient extends ProtectedBackEndClient<SessionDto> {
    @Value("${app.api.backend.path.session}")
    private String path;

    @Override
    protected Class<SessionDto> getResponseType() {
        return SessionDto.class;
    }

    @Override
    protected String getPath() {
        return path;
    }

    public ResponseEntity<SessionDto> doGetByUniqueKey(Integer exerciseId, Integer pairId){
        String url = UriComponentsBuilder.fromHttpUrl(getUrl() + getPath()+ "/unique")
                .queryParam("exerciseId", "{exerciseId}")
                .queryParam("pairId", "{pairId}")
                .encode()
                .toUriString();

        HashMap<String,Integer> params = new HashMap<>();
        params.put("exerciseId",exerciseId);
        params.put("pairId",pairId);

        return getRestTemplate().exchange(url, HttpMethod.GET, getHttpEntity(), getResponseType(), params);
    }
}
