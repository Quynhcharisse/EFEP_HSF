package com.hsf301.efep.controllers;

import com.hsf301.efep.serivces.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/seller")
public class SellerController {

    private final ShopService sellerService;

}
