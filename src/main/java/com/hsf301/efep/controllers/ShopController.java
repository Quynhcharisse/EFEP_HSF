package com.hsf301.efep.controllers;

import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.serivces.ShopService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/seller")
public class ShopController {

    private final ShopService shopService;

             //----------------FLOWER FOR SHOP---------------//

    //-------------------GET ALL FLOWER STATUS-----------------//

    @GetMapping("/flower/status")
    public List<String> getAllFlowerStatus() {
        return shopService.getAllFlowerStatus();
    }

    //------------------------CREATE FLOWER---------------------//

    @PostMapping("/flower")
    public String createFlower(CreateFlowerRequest request, HttpSession session, Model model) {
        return shopService.createFlower(request, session, model);
    }

    //-------------------------VIEW FLOWER FOR SHOP---------------------//

    @GetMapping("/flower")
    public String viewFlowerListForShop(ViewFlowerListRequest request, HttpSession session, Model model, int sellerId) {
        return shopService.viewFlowerListForShop(request, session, model, sellerId);
    }

    //------------------------UPDATE FLOWER---------------------//

    @PutMapping("/flower")
    public String updateFlower(UpdateFlowerRequest request, HttpSession session, Model model) {
        return shopService.updateFlower(request, session, model);
    }

    //-------------------DELETE FLOWER---------------------//

    @DeleteMapping("/flower")
    public String deleteFlower(DeleteFlowerRequest request, HttpSession session, Model model) {
        return shopService.deleteFlower(request, session, model);
    }

               //----------ORDER FOR SHOP(SELLER SHOP)------------//

    //-------------------------CHANGE ORDER STATUS---------------------//

    @PutMapping("/order/status")
    public String changeOrderStatus(ChangeOrderStatusRequest request, HttpSession session, Model model) {
        return shopService.changeOrderStatus(request, session, model);
    }

    //-------------------------VIEW ORDER DETAIL---------------------//

    @PutMapping("/order/detail")
    public String viewOrderDetail(ViewOrderDetailRequest request, HttpSession session, Model model) {
        return shopService.viewOrderDetail(request, session, model);
    }

    //-------------------------VIEW ORDER LIST-------------------------//

    @GetMapping("/order/list")
    public String viewOrderList(HttpSession session, Model model, int accountId) {
        return shopService.viewOrderList(session, model, accountId);
    }


    //---------------------------------------------------------------//
}
