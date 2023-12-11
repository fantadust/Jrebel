package com.github.jrebel.core.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class IndexController {

    @RequestMapping({"/", ""})
    @SneakyThrows
    @ResponseBody
    public String index(HttpServletRequest request, HttpServletResponse response) {
        String licenseUrl = System.getenv().getOrDefault("licenseUrl", request.getServerName() + (request.getServerPort() == 80 ? "" : ":" + request.getServerPort()));
        String protocol = System.getenv().getOrDefault("protocol", "http://");
//

        StringBuffer sb = new StringBuffer();
        sb.append(protocol);
        sb.append(licenseUrl);
        sb.append("/").append(UUID.randomUUID());

        return sb.toString();

    }


}
