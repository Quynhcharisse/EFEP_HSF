package com.hsf301.efep.service_implementors;

import com.hsf301.efep.enums.Roles;
import com.hsf301.efep.enums.Status;
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
        return getCustomerAmountLogic();
    }

    private GetCustomerAmountResponse getCustomerAmountLogic() {
        return GetCustomerAmountResponse.builder()
                .status("200")
                .message("")
                .amount(accountRepo.countByRole(Roles.CUSTOMER))
                .build();
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
        return getFlowerAmountLogic();
    }

    private GetFlowerAmountResponse getFlowerAmountLogic() {
        return GetFlowerAmountResponse.builder()
                .status("200")
                .message("")
                .amount(flowerRepo.countByStatus(Status.FLOWER_AVAILABLE))
                .build();
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
