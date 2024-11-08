package com.hsf301.efep.service_implementors;

import com.hsf301.efep.configurations.ReturnPageConfig;
import com.hsf301.efep.enums.ActionCaseValues;
import com.hsf301.efep.enums.Roles;
import com.hsf301.efep.enums.Status;
import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.entity_models.Category;
import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.entity_models.Order;
import com.hsf301.efep.models.request_models.GetFlowerDetailRequest;
import com.hsf301.efep.models.response_models.*;
import com.hsf301.efep.repositories.*;
import com.hsf301.efep.services.SystemService;
import com.hsf301.efep.validations.GetFlowerDetailValidation;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private final OrderRepo orderRepo;
    private final CategoryRepo categoryRepo;
    private final WishlistItemRepo wishlistItemRepo;

    //-----------------Get Top 10 Sold Flower----------------------//
    @Override
    public GetTopSoldFlowerResponse getTop8SoldFlower() {
        return getTop8SoldFlowerLogic();
    }

    private GetTopSoldFlowerResponse getTop8SoldFlowerLogic() {
        List<Flower> flowers = new ArrayList<>(flowerRepo.findAll());
        flowers = flowers.stream()
                .sorted(
                        Comparator.comparing(Flower::getSoldQuantity)
                                .reversed()
                )
                .limit(8)
                .toList();

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

    //--------------------TEST--------------------//

    public GetTopSoldFlowerResponse getTop8SoldFlowerLogicTest() {
        List<Flower> flowers = new ArrayList<>(flowerRepo.findAll());
        flowers = flowers.stream()
                .sorted(
                        Comparator.comparing(Flower::getSoldQuantity)
                        .reversed()
                )
                .limit(8)
                .toList();

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

    //-----------------Get Top 2 Sold Flower----------------------//
    @Override
    public GetTopSoldFlowerResponse getTop2SoldFlower() {
        return getTop2SoldFlowerLogic();
    }

    private GetTopSoldFlowerResponse getTop2SoldFlowerLogic() {
        List<Flower> flowers = new ArrayList<>(flowerRepo.findAll());
        flowers.sort(Comparator.comparing(Flower::getSoldQuantity).reversed());
        flowers = flowers.stream().limit(2).toList();

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

    //--------------------TEST--------------------//

    public GetTopSoldFlowerResponse getTop2SoldFlowerLogicTest() {
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
    public GetCustomerAmountResponse getCustomerAmount() {
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
    public GetFlowerAmountResponse getFlowerAmount() {
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
    public GetWorkingYearAmountResponse getWorkingYearAmount() {
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

    //-----------------Get Order Amount----------------------//
    @Override
    public GetOrderAmountResponse getOrderAmount() {
        return getOrderAmountLogic();
    }

    private GetOrderAmountResponse getOrderAmountLogic() {
        return GetOrderAmountResponse.builder()
                .status("200")
                .message("")
                .amount((int) orderRepo.findAll().stream().filter(o -> o.getStatus().equals(Status.ORDER_COMPLETE)).count())
                .build();
    }

    //--------------------TEST--------------------//

    public GetOrderAmountResponse getOrderAmountLogicTest() {
        return GetOrderAmountResponse.builder()
                .status("200")
                .message("")
                .amount((int) orderRepo.findAll().stream().filter(o -> o.getStatus().equals(Status.ORDER_COMPLETE)).count())
                .build();
    }

    //-----------------Get Order Amount----------------------//
    @Override
    public GetFlowerNumberPerCategoryResponse getFlowerNumberPerCategory(int top) {
        return getFlowerNumberPerCategoryLogic(top);
    }

    private GetFlowerNumberPerCategoryResponse getFlowerNumberPerCategoryLogic(int top) {
        List<Category> categories = new ArrayList<>(categoryRepo.findAll());
        categories.sort(Comparator.comparing((Category c) -> c.getFlowerList().size()).reversed());
        if(top > 0){
            return GetFlowerNumberPerCategoryResponse.builder()
                    .status("200")
                    .message("")
                    .categories(
                            categories.stream()
                                    .limit(top)
                                    .map(
                                            category -> GetFlowerNumberPerCategoryResponse.Category.builder()
                                                    .id(category.getId())
                                                    .name(category.getName())
                                                    .flowerNumber(flowerRepo.findAllByCategory_IdAndStatus(category.getId(), Status.FLOWER_AVAILABLE).size())
                                                    .percentage(getPercentage(category))
                                                    .build()
                                    )
                                    .toList()
                    )
                    .build();
        }
        return GetFlowerNumberPerCategoryResponse.builder()
                .status("200")
                .message("")
                .categories(
                        categories.stream()
                                .map(
                                        category -> GetFlowerNumberPerCategoryResponse.Category.builder()
                                                .id(category.getId())
                                                .name(category.getName())
                                                .flowerNumber(flowerRepo.findAllByCategory_IdAndStatus(category.getId(), Status.FLOWER_AVAILABLE).size())
                                                .percentage(getPercentage(category))
                                                .build()
                                )
                                .toList()
                )
                .build();
    }

    private float getPercentage(Category category) {
        float flowerAmount = flowerRepo.findAllByCategory_IdAndStatus(category.getId(), Status.FLOWER_AVAILABLE).size();
        float flowerTotal = flowerRepo.findAll().stream().filter(f -> f.getStatus().equals(Status.FLOWER_AVAILABLE)).toList().size();
        return (float) (Math.round((flowerAmount / flowerTotal) * 100) / 1.00);
    }

    //-----------------Get New Arrival Flower----------------------//
    @Override
    public GetNewArrivalFlowerResponse getNewArrivalFlower() {
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
    public GetTeammateResponse getTeammate() {
        return getTeammateLogic();
    }

    private GetTeammateResponse getTeammateLogic() {

        String leader = "CEO & Founder & CTO";
        String member = "CTO";

        List<GetTeammateResponse.Teammate> teammates = new ArrayList<>();
        teammates.add(createTeammate(
                "/img/team-img/quynh.jpg",
                "Pham Van Nhu Quynh",
                leader,
                "https://github.com/Quynhcharisse",
                "https://www.facebook.com/profile.php?id=100086284622452")
        );
        teammates.add(createTeammate(
                "/img/team-img/tri.jpg",
                "Dong Thanh Minh Tri",
                member,
                "",
                "")
        );
        teammates.add(createTeammate(
                "/img/team-img/hai.jpg",
                "Le Quang Hai",
                member,
                "https://github.com/hai65",
                "https://www.facebook.com/hai.lequang.52459/")
        );

        return GetTeammateResponse.builder()
                .status("200")
                .message("")
                .teammates(teammates)
                .build();
    }

    private GetTeammateResponse.Teammate createTeammate(String img, String name, String role, String github, String facebook) {
        return GetTeammateResponse.Teammate.builder()
                .image(img)
                .name(name)
                .role(role)
                .github(github)
                .facebook(facebook)
                .build();
    }

    //--------------------TEST--------------------//

    public GetTeammateResponse getTeammateLogicTest() {

        String leader = "CEO & Founder & CTO";
        String member = "CTO";

        List<GetTeammateResponse.Teammate> teammates = new ArrayList<>();
        teammates.add(createTeammate(
                "https://lh3.google.com/u/4/d/1dyCFcuRNbyFtnFRaJ0Bd76Jcm2Vk_16U=w1832-h928-iv1",
                "Pham Van Nhu Quynh",
                leader,
                "https://github.com/Quynhcharisse",
                "https://www.facebook.com/profile.php?id=100086284622452")
        );
        teammates.add(createTeammate(
                "https://lh3.google.com/u/4/d/1R3VaeupvHAZ1lXKPF8bEV-rIwMifKeEM=w1832-h928-iv1",
                "Dong Thanh Minh Tri",
                member,
                "",
                "")
        );
        teammates.add(createTeammate(
                "https://lh3.google.com/u/4/d/1cQtfLc5Vj6EGBlVK-zf5d6CE3CKZOlC6=w1832-h928-iv1",
                "Le Quang Hai",
                member,
                "https://github.com/hai65",
                "https://www.facebook.com/hai.lequang.52459/")
        );

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
        attributes.addFlashAttribute("flowerDetail", response);
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
                                .id(flower.getId())
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
                                .id(flower.getId())
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
        if (response.getStatus().equals("403"))
            return ReturnPageConfig.generateReturnMapping(ActionCaseValues.AUTHED_FAIL);
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
    public String getFlowerListForShop(RedirectAttributes attributes, HttpSession session) {
        GetFlowerListForShopResponse response = getFlowerListForShopLogic(Roles.getCurrentLoggedAccount(session));
        attributes.addFlashAttribute(response.getStatus().equals("200") ? "msg" : "error", response);
        if (response.getStatus().equals("403"))
            return ReturnPageConfig.generateReturnMapping(ActionCaseValues.AUTHED_FAIL);
        return ReturnPageConfig.generateReturnMapping(ActionCaseValues.SHOP_FLOWER);
    }

    private GetFlowerListForShopResponse getFlowerListForShopLogic(Account account) {
        if (account == null || !Roles.checkIfThisAccountIsShop(account)) {
            return GetFlowerListForShopResponse.builder()
                    .status("403")
                    .message("Please login the shop account first")
                    .flowers(null)
                    .build();
        }
        return GetFlowerListForShopResponse.builder()
                .status("200")
                .message("")
                .flowers(
                        flowerRepo.findAll().stream()
                                .map(
                                        f -> GetFlowerListForShopResponse.Flower.builder()
                                                .id(f.getId())
                                                .name(f.getName())
                                                .img(f.getImg())
                                                .status(f.getStatus())
                                                .qty(f.getQuantity())
                                                .build()
                                )
                                .toList()
                )
                .build();
    }

    //--------------------TEST--------------------//
    public GetFlowerListForShopResponse getFlowerListForShopLogicTest(Account account) {
        if (account == null || !Roles.checkIfThisAccountIsShop(account)) {
            return GetFlowerListForShopResponse.builder()
                    .status("403")
                    .message("Please login the shop account first")
                    .flowers(null)
                    .build();
        }
        return GetFlowerListForShopResponse.builder()
                .status("200")
                .message("")
                .flowers(
                        flowerRepo.findAll().stream()
                                .map(
                                        f -> GetFlowerListForShopResponse.Flower.builder()
                                                .id(f.getId())
                                                .name(f.getName())
                                                .img(f.getImg())
                                                .status(f.getStatus())
                                                .qty(f.getQuantity())
                                                .build()
                                )
                                .toList()
                )
                .build();
    }

    //-----------------Get Flower List----------------------//

    @Override
    public GetFlowerListResponse getFlowerList(int page, int size) {
        return getFlowerListLogic(page, size);
    }

    private GetFlowerListResponse getFlowerListLogic(int page, int size) {
        Page<Flower> flowers = flowerRepo.findAllByStatus(Status.FLOWER_AVAILABLE, PageRequest.of(page, size));
        return GetFlowerListResponse.builder()
                .status("200")
                .message("")
                .currentPage(page + 1)
                .totalPages(flowers.getTotalPages())
                .totalElements(flowers.getTotalElements())
                .maxPrice(calculateMaxPrice(flowerRepo.findAllByStatus(Status.FLOWER_AVAILABLE)))
                .minPrice(calculateMinPrice(flowerRepo.findAllByStatus(Status.FLOWER_AVAILABLE)))
                .keyword("")
                .flowers(
                        flowers.stream()
                                .map(
                                        f -> GetFlowerListResponse.Flower.builder()
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

    private int calculateMinPrice(List<Flower> flowers) {
        return (int) Math.floor(flowers.stream().sorted(Comparator.comparing(Flower::getPrice)).toList().get(0).getPrice());
    }

    private int calculateMaxPrice(List<Flower> flowers){
        return (int) Math.ceil(flowers.stream().sorted(Comparator.comparing(Flower::getPrice).reversed()).toList().get(0).getPrice());
    }

    //--------------------TEST--------------------//
    public GetFlowerListResponse getFlowerListLogicTest(int page, int size) {
        Page<Flower> flowers = flowerRepo.findAllByStatus(Status.FLOWER_AVAILABLE, PageRequest.of(page, size));
        return GetFlowerListResponse.builder()
                .status("200")
                .message("")
                .currentPage(page + 1)
                .totalPages(flowers.getTotalPages())
                .totalElements(flowers.getTotalElements())
                .maxPrice(calculateMaxPrice(flowerRepo.findAllByStatus(Status.FLOWER_AVAILABLE)))
                .minPrice(calculateMinPrice(flowerRepo.findAllByStatus(Status.FLOWER_AVAILABLE)))
                .keyword("")
                .flowers(
                        flowers.stream()
                                .map(
                                        f -> GetFlowerListResponse.Flower.builder()
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


    //-----------------Get Flower List V2----------------------//

    @Override
    public GetFlowerListResponse getFlowerList(Page<Flower> flowers, int page, String keyword) {
        return getFlowerListLogic(flowers, page, keyword);
    }

    private GetFlowerListResponse getFlowerListLogic(Page<Flower> flowers, int page, String keyword) {
        return GetFlowerListResponse.builder()
                .status("200")
                .message("")
                .currentPage(page + 1)
                .totalPages(flowers.getTotalPages())
                .totalElements(flowers.getTotalElements())
                .maxPrice(calculateMaxPrice(flowerRepo.findAllByStatus(Status.FLOWER_AVAILABLE)))
                .minPrice(calculateMinPrice(flowerRepo.findAllByStatus(Status.FLOWER_AVAILABLE)))
                .keyword(keyword)
                .flowers(
                        flowers.stream()
                                .map(
                                        f -> GetFlowerListResponse.Flower.builder()
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


    @Override
    public String getWishListItem(HttpSession session, RedirectAttributes attributes){
        GetWishListItemResponse response = getWishListItemLogic(Roles.getCurrentLoggedAccount(session));
        attributes.addFlashAttribute(response.getStatus().equals("200") ? "items" : "error", response);
        if(response.getStatus().equals("403")) return ReturnPageConfig.generateReturnMapping(ActionCaseValues.AUTHED_FAIL);
        return ReturnPageConfig.generateReturnMapping(ActionCaseValues.ADD_TO_WISHLIST);
    }

    private GetWishListItemResponse getWishListItemLogic(Account account){
        if(account == null || !Roles.checkIfThisAccountIsCustomer(account)){
            return GetWishListItemResponse.builder()
                    .status("403")
                    .message("Please login a customer account first")
                    .items(new ArrayList<>())
                    .build();
        }
        return GetWishListItemResponse.builder()
                .status("200")
                .message("")
                .items(
                        wishlistItemRepo.findAllByWishlist_User_Account_Id(account.getId()).stream()
                                .map(
                                        item -> GetWishListItemResponse.Item.builder()
                                                .id(item.getId())
                                                .name(item.getFlower().getName())
                                                .quantity(item.getQuantity())
                                                .price(item.getFlower().getPrice())
                                                .flower(item.getFlower())
                                                .build()
                                )
                                .toList()
                )
                .build();
    }
}
