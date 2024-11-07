package com.hsf301.efep.service_implementors;

import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.request_models.GetFlowerDetailRequest;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.repositories.AccountRepo;
import com.hsf301.efep.repositories.FlowerRepo;
import com.hsf301.efep.services.SystemService;
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
        return null;
    }

    private GetSlideBarImageResponse getSlideBarImageLogic(RedirectAttributes attributes) {
        return null;
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
        return null;
    }

    public GetTopSoldFlowerResponse getTopSoldFlowerLogic() {
        return null;
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
        return null;
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
        return null;
    }


    //-----------------Get Working Year Amount----------------------//
    @Override
    public GetWorkingYearAmountResponse getWorkingYearAmount(RedirectAttributes attributes) {
        return null;
    }

    public GetWorkingYearAmountResponse getWorkingYearAmountLogic() {
        return null;
    }

    //--------------------TEST--------------------//

    public GetWorkingYearAmountResponse getWorkingYearAmountLogicTest() {
        return null;
    }

    //-----------------Get New Arrival Flower----------------------//
    @Override
    public GetNewArrivalFlowerResponse getNewArrivalFlower(RedirectAttributes attributes) {
        return null;
    }

    private GetNewArrivalFlowerResponse getNewArrivalFlowerLogic() {
        return null;
    }

    //--------------------TEST--------------------//

    public GetNewArrivalFlowerResponse getNewArrivalFlowerLogicTest() {

        return null;
    }


    //-----------------Get Teammate----------------------//
    @Override
    public GetTeammateResponse getTeammate(RedirectAttributes attributes) {
        return null;
    }

    public GetTeammateResponse getTeammateLogic() {
        return null;
    }

    //--------------------TEST--------------------//
    public GetTeammateResponse getTeammateLogicTest() {

        return null;
    }

    //-----------------Get Flower Detail----------------------//
    @Override
    public String getFlowerDetail(GetFlowerDetailRequest request, RedirectAttributes attributes) {
        return "";
    }

    private GetFlowerDetailResponse getFlowerDetailLogic(GetFlowerDetailRequest request) {
        return null;
    }

    //--------------------TEST--------------------//

    public GetFlowerDetailResponse getFlowerDetailLogicTest(GetFlowerDetailRequest request) {
        return null;
    }


    //-----------------Get Customer Order History----------------------//
    @Override
    public String getCustomerOrderHistory(RedirectAttributes attributes) {
        return "";
    }

    private GetCustomerOrderHistoryResponse getCustomerOrderHistoryLogic(Account account) {
        return null;
    }
    //--------------------TEST--------------------//

    public GetCustomerOrderHistoryResponse getCustomerOrderHistoryLogicTest(Account account) {
        return null;
    }

    //-----------------Get Customer List For Shop----------------------//
    @Override
    public String getCustomerListForShop(RedirectAttributes attributes) {
        return "";
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
