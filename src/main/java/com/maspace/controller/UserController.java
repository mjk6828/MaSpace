package com.maspace.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UserController {

    @GetMapping("/users")
    public Object Users() {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("msg", "success");
        return result;
    }
}
