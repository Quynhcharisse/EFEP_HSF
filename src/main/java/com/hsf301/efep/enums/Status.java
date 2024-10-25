package com.hsf301.efep.enums;

import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.models.entity_models.Flower;
import com.hsf301.efep.models.entity_models.Order;
import com.hsf301.efep.repositories.AccountRepo;
import com.hsf301.efep.repositories.FlowerRepo;
import com.hsf301.efep.repositories.OrderRepo;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Status {

    public static String ORDER_STATUS_PROCESSING = "processing";
    public static String ORDER_STATUS_PACKED = "packed";
    public static String ORDER_STATUS_COMPLETED = "completed";
    public static String ORDER_STATUS_CANCELLED = "cancelled";

    public static String FLOWER_STATUS_AVAILABLE = "available";
    public static String FLOWER_STATUS_OUT_OF_STOCK = "out of stock";
    public static String FLOWER_STATUS_DELETED = "deleted";

    public static void changeAccountStatus(Account account, String status, AccountRepo accountRepo) {
        account.setStatus(status);
        accountRepo.save(account);
    }

    public static void changeOrderStatus(Order order, String status, OrderRepo orderRepo) {
        order.setStatus(status);
        orderRepo.save(order);
    }

    public static void changeFlowerStatus(Flower flower, String status, FlowerRepo flowerRepo) {
        flower.setStatus(status);
        flowerRepo.save(flower);
    }

    public static List<String> getFlowerStatusList() {
        List<String> flowerStatuses = new ArrayList<>();

        Field[] fields = Status.class.getFields();

        for(Field field : fields) {
            if(field.getName().contains("FLOWER_STATUS")) {
                try {
                    flowerStatuses.add((String) field.get(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return flowerStatuses;
    }
}
