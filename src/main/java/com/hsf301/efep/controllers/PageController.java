package com.hsf301.efep.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {

    @GetMapping("/")
    public String landingPage() {
        return "login";
    }

    @GetMapping("/forget")
    public String forgetPassPage() {
        return "fogotpassword";
    }
}
