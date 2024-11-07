package com.quynh.efep_hsf.controllers;

import com.quynh.efep_hsf.models.response_models.LoginResponse;
import com.quynh.efep_hsf.utils.ResponseHandlerUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequiredArgsConstructor
public class PageController {

    @GetMapping("/")
    public String landingPage(){
        return "index";
    }

    @GetMapping("/about")
    public String aboutPage(){return "about";}

    @GetMapping("/shop")
    public String shopPage(){return "shop";}

    @GetMapping("/portfolio")
    public String portfolioPage(){return "portfolio";}

    @GetMapping("/contact")
    public String contactPage(){return "contact";}

    @GetMapping("/blog")
    public String blogPage(){return "blog";}

    @GetMapping("/cart")
    public String cartPage(){return "cart";}

    @GetMapping("/pay")
    public String checkOutPage(){return "checkout";}

    @GetMapping("/login")
    public String loginPage(Model model){
        Object response = model.getAttribute("response");

        if(response != null){
            //check login response
            if(ResponseHandlerUtil.checkResponse(response, LoginResponse.class)){
                ResponseHandlerUtil.initResponse(response, ((LoginResponse) response).getStatus(), model);
            }
        }


        return "login";
    }
}
