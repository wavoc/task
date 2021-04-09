package com.test.task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping
@ApiIgnore
public class SwaggerController {

    @GetMapping
    public void getApiDocumentation(HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui.html");
    }

}
