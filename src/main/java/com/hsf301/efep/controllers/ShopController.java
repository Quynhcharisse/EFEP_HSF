package com.hsf301.efep.controllers;

import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.serivces.ShopService;
import io.swagger.v3.oas.annotations.Operation;
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

    //------------------------CREATE FLOWER---------------------//

    @PostMapping("/flower")
    public String createFlower(CreateFlowerRequest request, HttpSession session, Model model) {
        return shopService.createFlower(request, session, model);
    }

    //-------------------------VIEW FLOWER---------------------//

    @GetMapping("/flower")
    public String viewFlowerListForShop(ViewFlowerListRequest request, HttpSession session, Model model) {
        return shopService.viewFlowerListForShop(request, session, model);
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
                         //---------FLOWER IMAGE ---------//


    @GetMapping("/flower/image")
    @Operation(hidden = true)
    public String viewFlowerImage(ViewFlowerImageRequest request, HttpSession session, Model model) {
        return shopService.viewFlowerImage(request, session, model);
    }

    @PostMapping("/flower/add/image")
    @Operation(hidden = true)
    public String addFlowerImage(AddFlowerImageRequest request, HttpSession session, Model model) {
        return shopService.addFlowerImage(request, session, model);
    }

    @DeleteMapping("/flower/image")
    @Operation(hidden = true)
    public String deleteFlowerImage(DeleteFlowerImageRequest request, HttpSession session, Model model) {
        return shopService.deleteFlowerImage(request, session, model);
    }

    @GetMapping("/flower/status")
    public List<String> getAllFlowerStatus() {
        return shopService.getAllFlowerStatus();
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
    public String viewOrderList(HttpSession session, Model model) {
        return shopService.viewOrderList(session, model);
    }
}
