package com.chat.common.controller;


import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.Socket;
import java.util.Arrays;

@Controller
public class MainController {

    @GetMapping("/index")
    public String index() {
        Arrays.stream(new WebProperties.Resources().getStaticLocations()).forEach(System.out::println);
        return "/index";
    }

}
