package com.hsf301.efep.service_implementors;

import com.hsf301.efep.enums.FailPageFor;
import com.hsf301.efep.enums.Status;
import com.hsf301.efep.enums.SuccessPageFor;
import com.hsf301.efep.logics.ShopLogic;
import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.serivces.ShopService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopLogic shopLogic;

                            //----------------FLOWER FOR SHOP---------------//

    //---------------------------------------GET ALL FLOWER STATUS------------------------------------------//

    @Override
    public List<String> getAllFlowerStatus() {
        return Status.getFlowerStatusList();
    }

    //-------------------------------------------CREATE FLOWER----------------------------------//
    @Override
    public String createFlower(CreateFlowerRequest request, HttpSession session, Model model) {
        CreateFlowerResponse response = shopLogic.createFlowerLogic(request);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.CREATE_FLOWER : FailPageFor.CREATE_FLOWER;
    }

    //-------------------------------------------VIEW FLOWER LIST FOR SHOP----------------------------------//

    @Override
    public String viewFlowerListForShop(ViewFlowerListRequest request, HttpSession session, Model model, int sellerId) {
        ViewFlowerListResponse response = shopLogic.viewFlowerForShopLogic(sellerId);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.VIEW_FLOWER_LIST_SHOP : FailPageFor.VIEW_FLOWER_LIST_SHOP;
    }


    //-------------------------------------------UPDATE FLOWER----------------------------------//

    @Override
    public String updateFlower(UpdateFlowerRequest request, HttpSession session, Model model) {
        UpdateFlowerResponse response = shopLogic.updateFlowerLogic(request);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.UPDATE_FLOWER : FailPageFor.UPDATE_FLOWER;
    }

    //-------------------------------------------DELETE FLOWER----------------------------------//

    @Override
    public String deleteFlower(DeleteFlowerRequest request, HttpSession session, Model model) {
        DeleteFlowerResponse response = shopLogic.deleteFlowerLogic(request);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.DELETE_FLOWER : FailPageFor.DELETE_FLOWER;
    }

                                //----------ORDER FOR SHOP(SELLER SHOP)------------//

    //--------------------------------------CHANGE ORDER STATUS---------------------------------------//

    @Override
    public String changeOrderStatus(ChangeOrderStatusRequest request, HttpSession session, Model model) {
        ChangeOrderStatusResponse response = shopLogic.changeOrderStatusLogic(request);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.CHANGE_ORDER_STATUS : FailPageFor.CHANGE_ORDER_STATUS;
    }

    //---------------------------------------VIEW ORDER DETAIL----------------------------------------//

    @Override
    public String viewOrderDetail(ViewOrderDetailRequest request, HttpSession session, Model model) {
        ViewOrderDetailResponse response = shopLogic.viewOrderDetailLogic(request);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.VIEW_ORDER_DETAIL : FailPageFor.VIEW_ORDER_DETAIL;
    }


    //---------------------------------------VIEW ORDER LIST------------------------------------------//

    @Override
    public String viewOrderList(HttpSession session, Model model, int accountId) {
        ViewOrderListResponse response = shopLogic.viewOrderList(accountId);
        model.addAttribute(response.getType(), response);
        return response.getStatus().equals("200") ? SuccessPageFor.VIEW_ORDER_LIST : FailPageFor.VIEW_ORDER_LIST;
    }

}
