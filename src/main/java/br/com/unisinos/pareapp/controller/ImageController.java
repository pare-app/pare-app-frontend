package br.com.unisinos.pareapp.controller;

import br.com.unisinos.pareapp.model.dto.entity.QuestionDto;
import br.com.unisinos.pareapp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {
    private final QuestionService questionService;

    @GetMapping("/question/{id}")
    public void showProductImage(@PathVariable Integer id,
                               HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");

        QuestionDto product = questionService.get(id);

        InputStream is = new ByteArrayInputStream(product.getImage());
        IOUtils.copy(is, response.getOutputStream());
    }
}
