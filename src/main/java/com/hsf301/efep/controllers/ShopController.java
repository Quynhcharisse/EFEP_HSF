package com.hsf301.efep.controllers;

import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.serivces.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/seller")
public class ShopController {

    private final ShopService shopService;

    //------------------------CREATE FLOWER---------------------//

    @PostMapping("/flower")
    @Operation(hidden = true)
    public String createFlower(CreateFlowerRequest request, HttpSession session, Model model) {
        return shopService.createFlower(request, session, model);
    }

    //-------------------------VIEW FLOWER---------------------//

    @GetMapping("/flower")
    public String viewFlowerList(ViewFlowerListRequest request, HttpSession session, Model model) {
        return shopService.viewFlowerList(request, session, model);
    }

    //------------------------UPDATE FLOWER---------------------//

    @PutMapping("/flower")
    @Operation(hidden = true)
    public String updateFlower(UpdateFlowerRequest request, HttpSession session, Model model) {
        return shopService.updateFlower(request, session, model);
    }

    //-------------------DELETE FLOWER---------------------//

    @DeleteMapping("/flower")
    @Operation(hidden = true)
    public String deleteFlower(DeleteFlowerRequest request, HttpSession session, Model model) {
        return shopService.deleteFlower(request, session, model);
    }

    //-------------------------CHANGE ORDER STATUS---------------------//

    @PutMapping("/order/status")
    @Operation(hidden = true)
    public String changeOrderStatus(ChangeOrderStatusRequest request, HttpSession session, Model model) {
        return shopService.changeOrderStatus(request, session, model);
    }

    //-------------------------VIEW ORDER DETAIL---------------------//

    @PutMapping("/order/detail")
    @Operation(hidden = true)
    public String viewOrderDetail(ViewOrderDetailRequest request, HttpSession session, Model model) {
        return shopService.viewOrderDetail(request, session, model);
    }

    //-------------------------VIEW ORDER LIST-------------------------//

    @GetMapping("/order/list")
    @Operation(hidden = true)
    public String viewOrderList(HttpSession session, Model model) {
        return shopService.viewOrderList(session, model);
    }


}
