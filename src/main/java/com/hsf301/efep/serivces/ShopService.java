package com.hsf301.efep.serivces;

import com.hsf301.efep.models.request_models.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

import java.util.List;

public interface ShopService {
    String createFlower(CreateFlowerRequest request, HttpSession session, Model model);

    String viewFlowerListForShop(ViewFlowerListRequest request, HttpSession session, Model model);

    String updateFlower(UpdateFlowerRequest request, HttpSession session, Model model);

    String deleteFlower(DeleteFlowerRequest request, HttpSession session, Model model);

    String changeOrderStatus(ChangeOrderStatusRequest request, HttpSession session, Model model);

    String viewOrderDetail(ViewOrderDetailRequest request, HttpSession session, Model model);

    String viewOrderList(HttpSession session, Model model);

    String viewFlowerImage(ViewFlowerImageRequest request, HttpSession session, Model model);

    String addFlowerImage(AddFlowerImageRequest request, HttpSession session, Model model);

    String deleteFlowerImage(DeleteFlowerImageRequest request, HttpSession session, Model model);

    List<String> getAllFlowerStatus();
}
