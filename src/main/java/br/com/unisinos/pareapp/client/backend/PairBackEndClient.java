package br.com.unisinos.pareapp.client.backend;

import br.com.unisinos.pareapp.model.dto.entity.PairDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PairBackEndClient extends ProtectedBackEndClient<PairDto> {
    @Value("${app.api.backend.path.pair}")
    private String path;

    @Override
    protected Class<PairDto> getResponseType() {
        return PairDto.class;
    }

    @Override
    protected String getPath() {
        return path;
    }
}
