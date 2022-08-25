package com.chat.common.controller;


import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.Socket;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

@Controller
public class MainController {

    @GetMapping("/index")
    public String index(Model model) {
        Arrays.stream(new WebProperties.Resources().getStaticLocations()).forEach(System.out::println);
        model.addAttribute("id", String.valueOf(UUID.randomUUID()).substring(0, 7));

        return "/index";
    }

}
