package com.quynh.efep_hsf.services;

import com.quynh.efep_hsf.models.entity_models.Flower;
import com.quynh.efep_hsf.models.request_models.*;
import com.quynh.efep_hsf.models.response_models.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public interface CustomerService {
    SearchFlowerResponse searchFlowers(SearchFlowerRequest request, RedirectAttributes attributes);
    SortFlowerResponse sortFlowers(SortFlowerRequest request, RedirectAttributes attributes);
    AddToWishListResponse addToWishList(AddToWishListRequest request, RedirectAttributes attributes);
    UpdateWishListResponse updateWishList(UpdateWishListRequest request, RedirectAttributes attributes);
    DeleteWishListResponse deleteWishList(DeleteWishListRequest request, RedirectAttributes attributes);
    CheckoutResponse checkout(RedirectAttributes attributes);
    GetContactResponse getContact(GetContactRequest request, RedirectAttributes attributes);
//    UpdateProfileResponse updateProfile(UpdateProfileRequest request, RedirectAttributes attributes);
//    ChangePasswordResponse changePassword(ChangePasswordRequest request, RedirectAttributes attributes);
}
