package com.hsf301.efep.controllers;

import com.hsf301.efep.serivces.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/buyer")
public class BuyerController {

    private final BuyerService buyerService;
}
