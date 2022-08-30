package com.chat.common.controller;


import com.chat.chat.config.StompConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.Socket;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

@Controller
public class MainController {

    private String portInfo;

    MainController(@Autowired String getPortInfo) {
        this.portInfo = getPortInfo;
    }


    @GetMapping("/index")
    public String index(Model model) {
        Arrays.stream(new WebProperties.Resources().getStaticLocations()).forEach(System.out::println);
        model.addAttribute("id", String.valueOf(UUID.randomUUID()).substring(0, 7));
        model.addAttribute("portInfo", portInfo);

        return "/index";
    }

}
