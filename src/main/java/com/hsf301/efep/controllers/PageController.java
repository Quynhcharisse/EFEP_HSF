package com.hsf301.efep.controllers;

import com.hsf301.efep.serivces.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final BuyerService buyerService;

}
