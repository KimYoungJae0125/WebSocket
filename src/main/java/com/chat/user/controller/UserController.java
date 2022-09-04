package com.chat.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public Map<String, String> getUserId() {
        return new HashMap<String, String>(){{put("id",String.valueOf(UUID.randomUUID()).substring(0, 7));}};
    }

}
