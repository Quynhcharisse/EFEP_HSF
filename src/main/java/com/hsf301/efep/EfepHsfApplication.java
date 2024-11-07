package com.hsf301.efep;

import com.hsf301.efep.enums.Roles;
import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.entity_models.User;
import com.hsf301.efep.models.request_models.*;
import com.hsf301.efep.models.request_models.DisableFlowerRequest;
import com.hsf301.efep.repositories.AccountRepo;
import com.hsf301.efep.repositories.FlowerRepo;
import com.hsf301.efep.service_implementors.AccountServiceImpl;
import com.hsf301.efep.service_implementors.CustomerServiceImpl;
import com.hsf301.efep.service_implementors.ShopServiceImpl;
import com.hsf301.efep.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@RequiredArgsConstructor
public class EfepHsfApplication {

    public static void main(String[] args) {
        SpringApplication.run(EfepHsfApplication.class, args);
    }

    private final AccountServiceImpl accountService;
    private final CustomerServiceImpl customerService;
    private final ShopServiceImpl shopService;

    private final AccountRepo accountRepo;
    private final FlowerRepo flowerRepo;

    @Bean
    public CommandLineRunner initData() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                //-----------------------------TEST-----------------------------//

                //--------------------Init--------------------//

                Account shop = accountRepo.findByRole(Roles.SHOP);
                Account customer1 = accountRepo.findByEmailAndPassword("test@gmail.com", "Quoc2802!!!").get();
                Account customer2 = accountRepo.findByEmailAndPassword("quoc@gmail.com", "husky03@@").get();

                //--------------------Login--------------------//
//				System.out.println(
//						accountService.loginLogicTest(
//								LoginRequest.builder()
//										.email("vannhuquynhp@gmail.com")
//										.password("Quynh123@!")
//										.build()
//						)
//				);

                //--------------------Register--------------------//
//				System.out.println(
//						accountService.registerLogicTest(
//								RegisterRequest.builder()
//										.email("test1@gmail.com")
//										.password("Satsuki2802#")
//										.confirmPassword("Satsuki2802#")
//										.name("Test")
//										.phone("0709090909")
//										.build()
//						)
//				);

                //--------------------Search flower--------------------//
//				System.out.println(
//						customerService.searchFlowersLogicTest(
//								SearchFlowerRequest.builder()
//										.keyword("e")
//										.build()
//						)
//				);

                //--------------------Sort flower--------------------//
//				System.out.println(
//						customerService.sortFlowersLogicTest(
//								SortFlowerRequest.builder()
//										.startPrice(0)
//										.endPrice(499)
//										.cateId("2")
//										.sortType("priceUp")
//										.build()
//						)
//				);

                //--------------------Add to wishlist--------------------//
//                System.out.println(
//                        customerService.addToWishListLogicTest(
//                                AddToWishListRequest.builder().flowerId(7).qty(30).build(),
//                                customer1
//                        )
//
//                );

                //--------------------Update wishlist--------------------//
//                System.out.println(
//                        customerService.updateWishListLogicTest(
//                                UpdateWishListRequest.builder()
//                                        .wishListItemId(2)
//                                        .newQty(50)
//                                        .build(),
//                                customer1
//                        )
//
//                );

                //--------------------Clear wishlist--------------------//
//                System.out.println(
//                        customerService.clearWishListLogicTest(customer2)
//                );

                //--------------------Check out--------------------//

//                List<CheckoutRequest.Item> items = new ArrayList<>();
//                items.add(CheckoutRequest.Item.builder().id(7).quantity(20).build());
//                items.add(CheckoutRequest.Item.builder().id(8).quantity(30).build());
//                System.out.println(
//                        customerService.checkoutLogicTest(
//                                CheckoutRequest.builder()
//                                        .items(items)
//                                        .build(),
//                                customer1
//                        )
//                );

//                //--------------------Create flower--------------------//
//
//                System.out.println(
//                        shopService.createFlowerLogicTest(
//                                CreateFlowerRequest.builder()
//                                        .name("Hoa Quoc")
//                                        .price(600)
//                                        .quantity(1000)
//                                        .flowerAmount(2)
//                                        .description("Hoa quoc dit bun bun")
//                                        .categoryId(2)
//                                        .build(), shop
//                        )
//                );

//                                //--------------------Update flower--------------------//
//                System.out.println(
//                        shopService.updateFlowerLogicTest(
//                                UpdateFlowerRequest.builder()
//                                        .id(10)
//                                        .name("Hoa Quoc")
//                                        .price(600)
//                                        .quantity(1000)
//                                        .flowerAmount(2)
//                                        .description("Hoa quoc is a beautiful")
//                                        .categoryId(2)
//                                        .build()
//                                , shop
//                        )
//                );

                                                //--------------------Update flower--------------------//
                System.out.println(
                        shopService.disableFlowerLogicTest(
                                DisableFlowerRequest.builder()
                                        .id(10)
                                        .build()
                                , shop
                        )
                );

            }
        };
    }
}


