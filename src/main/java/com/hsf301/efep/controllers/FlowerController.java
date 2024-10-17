package com.hsf301.efep.controllers;

import com.hsf301.efep.serivces.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/flower")
public class FlowerController {

    private final FlowerService flowerService;
}
