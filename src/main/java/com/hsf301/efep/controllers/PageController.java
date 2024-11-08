package com.hsf301.efep.controllers;

import com.hsf301.efep.enums.PageSize;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.services.SystemService;
import com.hsf301.efep.utils.ResponseHandlerUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final SystemService systemService;

    @GetMapping("/")
    public String landingPage(Model model){
        model.addAttribute("top8Flower", systemService.getTop8SoldFlower());
        model.addAttribute("top2Flower", systemService.getTop2SoldFlower());
        return "index";
    }

    @GetMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("flowerAmount", systemService.getFlowerAmount());
        model.addAttribute("customerAmount", systemService.getCustomerAmount());
        model.addAttribute("orderAmount", systemService.getOrderAmount());
        model.addAttribute("workingYear", systemService.getWorkingYearAmount());
        model.addAttribute("team", systemService.getTeammate());
        model.addAttribute("flowerPerCate", systemService.getFlowerNumberPerCategory(4));
        model.addAttribute("top2Flower", systemService.getTop2SoldFlower());
        return "about";
    }

    @GetMapping("/shop")
    public String shopPage(Model model, @RequestParam(defaultValue = "1") int page){
        model.addAttribute("top2Flower", systemService.getTop2SoldFlower());
        if(model.getAttribute("flowerList") != null){
            model.addAttribute("flowerList", (GetFlowerListResponse) model.getAttribute("flowerList"));

        }else{
            model.addAttribute("flowerList", systemService.getFlowerList(page - 1, PageSize.SIZE));
        }
        model.addAttribute("flowerPerCate", systemService.getFlowerNumberPerCategory(0));
        return "shop";
    }
    // Model: truyền 1 lần, bộ nhớ tạm nội bộ model đó
    // Redirect attribute: truyền 1 lần, bộ nhớ có thể truy cập từ tất cả model
    // Session: truyền không giới hạn, bộ nhớ có thể truy cập từ mọi nơi trong phần mềm
    @GetMapping("/flower/detail")
    public String shopDetail(Model model){
        model.addAttribute("top2Flower", systemService.getTop2SoldFlower());
        if(model.getAttribute("flowerDetail") == null){
            return "redirect:/404";
        }
        model.addAttribute("flowerDetail", (GetFlowerDetailResponse) model.getAttribute("flowerDetail"));
        model.addAttribute("top8Flower", systemService.getTop8SoldFlower());
        return "shop-details";
    }

    @GetMapping("/portfolio")
    public String portfolioPage(){return "portfolio";}

    @GetMapping("/contact")
    public String contactPage(){return "contact";}

    @GetMapping("/blog")
    public String blogPage(){return "blog";}

    @GetMapping("/wishlist")
    public String wishListPage(Model model){
        model.addAttribute("top2Flower", systemService.getTop2SoldFlower());
        model.addAttribute("items", (AddToWishListResponse) model.getAttribute("items"));
        return "wishlist";
    }

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

    @GetMapping("/404")
    public String notFoundPage(Model model){
        model.addAttribute("top2Flower", systemService.getTop2SoldFlower());
        return "404";
    }

    @GetMapping("/soon")
    public String comingSoonPage(Model model){
        model.addAttribute("top2Flower", systemService.getTop2SoldFlower());
        return "comingSoon";
    }
}
