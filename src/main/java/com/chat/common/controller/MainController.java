package com.chat.common.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class MainController {

    private String portInfo;

    MainController(@Autowired String getPortInfo) {
        this.portInfo = getPortInfo;
    }


    @GetMapping("/index")
    public String index(Model model) {
        Arrays.stream(new WebProperties.Resources().getStaticLocations()).forEach(System.out::println);
        model.addAttribute("portInfo", portInfo);

        return "/index";
    }

}
