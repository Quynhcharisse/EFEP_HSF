package com.hsf301.efep.service_implementors;

import com.hsf301.efep.configurations.ReturnPageConfig;
import com.hsf301.efep.enums.Roles;
import com.hsf301.efep.enums.Status;
import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.entity_models.Order;
import com.hsf301.efep.models.request_models.GetFlowerDetailRequest;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.repositories.AccountRepo;
import com.hsf301.efep.enums.ActionCaseValues;
import com.hsf301.efep.repositories.FlowerRepo;
import com.hsf301.efep.services.SystemService;
import com.hsf301.efep.validations.GetFlowerDetailValidation;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SystemServiceImpl implements SystemService {
    private final FlowerRepo flowerRepo;
    private final AccountRepo accountRepo;

    //-----------------Get Slide Bar Image----------------------//
    @Override
    public GetSlideBarImageResponse getSlideBarImage(RedirectAttributes attributes) {
        return getSlideBarImageLogic();
    }

    private GetSlideBarImageResponse getSlideBarImageLogic() {
        return GetSlideBarImageResponse.builder()
                .status("200")
                .message("")
                .link1("https://www.frankstonflorist.com.au/wp-content/uploads/slider/cache/47326b2292695347818ef2497f3fef9e/slider-flowers.jpg")
                .link2("https://www.lgflowers.nl/templates/yootheme/cache/9a/lg-flowers-slider-6-9a1be667.jpeg")
                .build();
    }

    //=-------------------------Test--------------------------//
    public GetSlideBarImageResponse getSlideBarImageLogicTest() {
        return GetSlideBarImageResponse.builder()
                .status("200")
                .message("")
                .link1("https://www.frankstonflorist.com.au/wp-content/uploads/slider/cache/47326b2292695347818ef2497f3fef9e/slider-flowers.jpg")
                .link2("https://www.lgflowers.nl/templates/yootheme/cache/9a/lg-flowers-slider-6-9a1be667.jpeg")
                .build();
    }
    //-----------------Get Top Sold Flower----------------------//
    @Override
    public GetTopSoldFlowerResponse getTopSoldFlower(RedirectAttributes attributes) {
        return getTopSoldFlowerLogic();
    }

    private GetTopSoldFlowerResponse getTopSoldFlowerLogic() {
        List<Flower> flowers = new ArrayList<>(flowerRepo.findAll());
        flowers.sort(Comparator.comparing(Flower::getSoldQuantity).reversed());
        flowers = flowers.stream().limit(10).toList();

        return GetTopSoldFlowerResponse.builder()
                .status("200")
                .message("")
                .flowers(
                        flowers.stream()
                                .map(
                                        f -> GetTopSoldFlowerResponse.Flower.builder()
                                                .id(f.getId())
                                                .name(f.getName())
                                                .price(f.getPrice())
                                                .img(f.getImg())
                                                .build()
                                )
                                .toList()
                )
                .build();
    }

    //=-------------------------Test--------------------------//
    public GetTopSoldFlowerResponse getTopSoldFlowerLogicTest() {
        List<Flower> flowers = new ArrayList<>(flowerRepo.findAll());
        flowers.sort(Comparator.comparing(Flower::getSoldQuantity).reversed());
        flowers = flowers.stream().limit(10).toList();
        return GetTopSoldFlowerResponse.builder()
                .status("200")
                .message("")
                .flowers(
                        flowers.stream()
                                .map(
                                        f -> GetTopSoldFlowerResponse.Flower.builder()
                                                .id(f.getId())
                                                .name(f.getName())
                                                .price(f.getPrice())
                                                .img(f.getImg())
                                                .build()
                                )
                                .toList()
                )
                .build();
    }

    //-----------------Get Customer Amount----------------------//
    @Override
    public GetCustomerAmountResponse getCustomerAmount(RedirectAttributes attributes) {
        return null;
    }

    public GetCustomerAmountResponse getCustomerAmountLogic() {
        return null;
    }

    //--------------------TEST--------------------//

    public GetCustomerAmountResponse getCustomerAmountLogicTest() {
        return GetCustomerAmountResponse.builder()
                .status("200")
                .message("")
                .amount(accountRepo.countByRole(Roles.CUSTOMER))
                .build();
    }

    //-----------------Get Flower Amount----------------------//
    @Override
    public GetFlowerAmountResponse getFlowerAmount(RedirectAttributes attributes) {
        return null;
    }

    private GetFlowerAmountResponse getFlowerAmountLogic() {
        return null;
    }

    //--------------------TEST--------------------//

    public GetFlowerAmountResponse getFlowerAmountLogicTest() {
        return GetFlowerAmountResponse.builder()
                .status("200")
                .message("")
                .amount(flowerRepo.countByStatus(Status.FLOWER_AVAILABLE))
                .build();
    }


    //-----------------Get Working Year Amount----------------------//
    @Override
    public GetWorkingYearAmountResponse getWorkingYearAmount(RedirectAttributes attributes) {
        return getWorkingYearAmountLogic();
    }

    private GetWorkingYearAmountResponse getWorkingYearAmountLogic() {
        return GetWorkingYearAmountResponse.builder()
                .status("200")
                .message("")
                .duration(
                        Period.between(
                                LocalDate.of(2022, 1, 1),
                                LocalDate.now()
                        ).getYears()
                )
                .build();
    }

    //--------------------TEST--------------------//

    public GetWorkingYearAmountResponse getWorkingYearAmountLogicTest() {
        return GetWorkingYearAmountResponse.builder()
                .status("200")
                .message("")
                .duration(
                        Period.between(
                                LocalDate.of(2022, 1, 1),
                                LocalDate.now()
                        ).getYears()
                )
                .build();
    }

    //-----------------Get New Arrival Flower----------------------//
    @Override
    public GetNewArrivalFlowerResponse getNewArrivalFlower(RedirectAttributes attributes) {
        return getNewArrivalFlowerLogic();
    }

    private GetNewArrivalFlowerResponse getNewArrivalFlowerLogic() {
        List<Flower> flowers = new ArrayList<>(flowerRepo.findAll());
        flowers.sort(Comparator.comparing(Flower::getId).reversed());
        flowers = flowers.stream().limit(10).toList();

        return GetNewArrivalFlowerResponse.builder()
                .status("200")
                .message("")
                .flowers(
                        flowers.stream()
                                .map(
                                        f -> GetNewArrivalFlowerResponse.Flower.builder()
                                                .id(f.getId())
                                                .name(f.getName())
                                                .price(f.getPrice())
                                                .img(f.getImg())
                                                .build()
                                )
                                .toList()
                )
                .build();
    }

    //--------------------TEST--------------------//

    public GetNewArrivalFlowerResponse getNewArrivalFlowerLogicTest() {
        List<Flower> flowers = new ArrayList<>(flowerRepo.findAll());
        flowers.sort(Comparator.comparing(Flower::getId).reversed());
        flowers = flowers.stream().limit(10).toList();

        return GetNewArrivalFlowerResponse.builder()
                .status("200")
                .message("")
                .flowers(
                        flowers.stream()
                                .map(
                                        f -> GetNewArrivalFlowerResponse.Flower.builder()
                                                .id(f.getId())
                                                .name(f.getName())
                                                .price(f.getPrice())
                                                .img(f.getImg())
                                                .build()
                                )
                                .toList()
                )
                .build();
    }


    //-----------------Get Teammate----------------------//
    @Override
    public GetTeammateResponse getTeammate(RedirectAttributes attributes) {
        return getTeammateLogic();
    }

    private GetTeammateResponse getTeammateLogic() {

        String leader = "CEO & Founder & CTO";
        String member = "CTO";

        List<GetTeammateResponse.Teammate> teammates = new ArrayList<>();
        teammates.add(createTeammate("", "Pham Van Nhu Quynh", leader));
        teammates.add(createTeammate("", "", member));
        teammates.add(createTeammate("", "", member));

        return GetTeammateResponse.builder()
                .status("200")
                .message("")
                .teammates(teammates)
                .build();
    }

    private GetTeammateResponse.Teammate createTeammate(String img, String name, String role) {
        return GetTeammateResponse.Teammate.builder().image(img).name(name).role(role).build();
    }

    //--------------------TEST--------------------//
    public GetTeammateResponse getTeammateLogicTest() {

        String leader = "CEO & Founder & CTO";
        String member = "CTO";

        List<GetTeammateResponse.Teammate> teammates = new ArrayList<>();
        teammates.add(createTeammate("", "Pham Van Nhu Quynh", leader));
        teammates.add(createTeammate("", "", member));
        teammates.add(createTeammate("", "", member));
        return GetTeammateResponse.builder()
                .status("200")
                .message("")
                .teammates(teammates)
                .build();
    }

    //-----------------Get Flower Detail----------------------//
    @Override
    public String getFlowerDetail(GetFlowerDetailRequest request, RedirectAttributes attributes) {
        GetFlowerDetailResponse response = getFlowerDetailLogic(request);
        attributes.addFlashAttribute("msg", response);
        return ReturnPageConfig.generateReturnMapping(ActionCaseValues.FLOWER_DETAIL);
    }

    private GetFlowerDetailResponse getFlowerDetailLogic(GetFlowerDetailRequest request) {
        String error = GetFlowerDetailValidation.validate(request, flowerRepo);
        if (!error.isEmpty()) {
            return GetFlowerDetailResponse.builder()
                    .status("400")
                    .message(error)
                    .flowerDetail(null)
                    .build();
        }

        Flower flower = flowerRepo.findById(request.getId()).get();

        return GetFlowerDetailResponse.builder()
                .status("200")
                .message("")
                .flowerDetail(
                        GetFlowerDetailResponse.FlowerDetail.builder()
                                .name(flower.getName())
                                .price(flower.getPrice())
                                .description(flower.getDescription())
                                .flowerAmount(flower.getFlowerAmount())
                                .img(flower.getImg())
                                .qty(flower.getQuantity())
                                .soldQty(flower.getSoldQuantity())
                                .status(flower.getStatus())
                                .category(flower.getCategory())
                                .build()
                )
                .build();
    }

    //--------------------TEST--------------------//

    public GetFlowerDetailResponse getFlowerDetailLogicTest(GetFlowerDetailRequest request) {
        String error = GetFlowerDetailValidation.validate(request, flowerRepo);
        if (!error.isEmpty()) {
            return GetFlowerDetailResponse.builder()
                    .status("400")
                    .message(error)
                    .flowerDetail(null)
                    .build();
        }

        Flower flower = flowerRepo.findById(request.getId()).get();

        return GetFlowerDetailResponse.builder()
                .status("200")
                .message("")
                .flowerDetail(
                        GetFlowerDetailResponse.FlowerDetail.builder()
                                .name(flower.getName())
                                .price(flower.getPrice())
                                .description(flower.getDescription())
                                .flowerAmount(flower.getFlowerAmount())
                                .img(flower.getImg())
                                .qty(flower.getQuantity())
                                .soldQty(flower.getSoldQuantity())
                                .status(flower.getStatus())
                                .category(flower.getCategory())
                                .build()
                )
                .build();
    }


    //-----------------Get Customer Order History----------------------//
    @Override
    public String getCustomerOrderHistory(RedirectAttributes attributes, HttpSession session) {
        GetCustomerOrderHistoryResponse response = getCustomerOrderHistoryLogic(Roles.getCurrentLoggedAccount(session));
        attributes.addFlashAttribute(response.getStatus().equals("200") ? "msg" : "error", response);
        if(response.getStatus().equals("403")) return ReturnPageConfig.generateReturnMapping(ActionCaseValues.AUTHED_FAIL);
        return ReturnPageConfig.generateReturnMapping(ActionCaseValues.ORDER_HISTORY);
    }

    private GetCustomerOrderHistoryResponse getCustomerOrderHistoryLogic(Account account) {
        if (account == null || !Roles.checkIfThisAccountIsCustomer(account)) {
            return GetCustomerOrderHistoryResponse.builder()
                    .status("400")
                    .message("Please login a customer account first")
                    .order(null)
                    .build();
        }

        List<Order> order = account.getUser().getOrderList();

        return GetCustomerOrderHistoryResponse.builder()
                .status("200")
                .message("")
                .order(
                        order.stream()
                                .map(
                                        o -> GetCustomerOrderHistoryResponse.Order.builder()
                                                .id(o.getId())
                                                .createdDate(o.getCreatedDate())
                                                .status(o.getStatus())
                                                .totalPrice(o.getTotalPrice())
                                                .build()
                                )
                                .toList()
                )
                .build();
    }
    //--------------------TEST--------------------//

    public GetCustomerOrderHistoryResponse getCustomerOrderHistoryLogicTest(Account account) {
        if (account == null || !Roles.checkIfThisAccountIsCustomer(account)) {
            return GetCustomerOrderHistoryResponse.builder()
                    .status("400")
                    .message("Please login a customer account first")
                    .order(null)
                    .build();
        }

        List<Order> order = account.getUser().getOrderList();

        return GetCustomerOrderHistoryResponse.builder()
                .status("200")
                .message("")
                .order(
                        order.stream()
                                .map(
                                        o -> GetCustomerOrderHistoryResponse.Order.builder()
                                                .id(o.getId())
                                                .createdDate(o.getCreatedDate())
                                                .status(o.getStatus())
                                                .totalPrice(o.getTotalPrice())
                                                .build()
                                )
                                .toList()
                )
                .build();
    }

    //-----------------Get Flower List For Shop----------------------//
    @Override
    public String getFlowerListForShop(RedirectAttributes attributes) {
        return "";
    }

    private GetFlowerListForShopResponse getFlowerListForShopLogic(Account account) {
        return null;
    }

    //--------------------TEST--------------------//
    public GetFlowerListForShopResponse getFlowerListForShopLogicTest(Account account) {
        return null;
    }

}
