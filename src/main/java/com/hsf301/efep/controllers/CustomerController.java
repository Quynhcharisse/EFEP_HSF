package com.hsf301.efep.controllers;

import ch.qos.logback.core.model.Model;
import com.hsf301.efep.models.request_models.AddToWishListRequest;
import com.hsf301.efep.models.request_models.GetFlowerDetailRequest;
import com.hsf301.efep.models.request_models.SearchFlowerRequest;
import com.hsf301.efep.models.request_models.SortFlowerRequest;
import com.hsf301.efep.services.CustomerService;
import com.hsf301.efep.services.SystemService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final SystemService systemService;

    @PostMapping("/sort")
    public String sort(SortFlowerRequest request, RedirectAttributes attributes) {
        return customerService.sortFlowers(request, attributes);
    }

    @GetMapping("/flower/detail")
    public String viewFlowerDetail(@RequestParam(name = "id") String id, RedirectAttributes attributes) {
        if(id == null){
            return "redirect:/404";
        }
        GetFlowerDetailRequest request = new GetFlowerDetailRequest(Integer.parseInt(id));
        return systemService.getFlowerDetail(request, attributes);
    }

    @PostMapping("/search")
    public String search(SearchFlowerRequest request, RedirectAttributes attributes) {
        return customerService.searchFlowers(request, attributes);
    }

    @PostMapping("/wishlist")
    public String addToWishlist(AddToWishListRequest request, RedirectAttributes attributes, HttpSession session) {
        return customerService.addToWishList(request, attributes, session);
    }

    @GetMapping("/wishlist")
    public String getWishlist(RedirectAttributes attributes, HttpSession session) {
        return systemService.getWishListItem(session, attributes);
    }
}
