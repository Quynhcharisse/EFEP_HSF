package com.hsf301.efep.enums;

import com.hsf301.efep.models.entity_models.Account;
import com.hsf301.efep.repositories.AccountRepo;
import jakarta.servlet.http.HttpSession;

public class Cons {

    public final static String ORDER_STATUS_PROCESSING = "processing";
    public final static String ORDER_STATUS_PACKED = "packed";
    public final static String ORDER_STATUS_FINISHED = "finished";
    public final static String ORDER_STATUS_CANCELLED = "cancelled";


    public final static String FLOWER_STATUS_AVAILABLE = "available";
    public final static String FLOWER_STATUS_OUT_OF_STOCK = "out-of-stock";
    public final static String FLOWER_STATUS_DELETED = "deleted";

}
