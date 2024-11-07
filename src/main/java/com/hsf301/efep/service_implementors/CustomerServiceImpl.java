package com.quynh.efep_hsf.service_implementors;

import com.quynh.efep_hsf.models.request_models.*;
import com.quynh.efep_hsf.models.response_models.*;
import com.quynh.efep_hsf.services.CustomerService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public SearchFlowerResponse searchFlowers(SearchFlowerRequest request, RedirectAttributes attributes) {
        return null;
    }

    @Override
    public SortFlowerResponse sortFlowers(SortFlowerRequest request, RedirectAttributes attributes) {
        return null;
    }

    @Override
    public AddToWishListResponse addToWishList(AddToWishListRequest request, RedirectAttributes attributes) {
        return null;
    }

    @Override
    public UpdateWishListResponse updateWishList(UpdateWishListRequest request, RedirectAttributes attributes) {
        return null;
    }

    @Override
    public DeleteWishListResponse deleteWishList(DeleteWishListRequest request, RedirectAttributes attributes) {
        return null;
    }

    @Override
    public CheckoutResponse checkout(RedirectAttributes attributes) {
        return null;
    }

    @Override
    public GetContactResponse getContact(GetContactRequest request, RedirectAttributes attributes) {
        return null;
    }

    @Override
    public UpdateProfileResponse updateProfile(UpdateProfileRequest request, RedirectAttributes attributes) {
        return null;
    }

    @Override
    public ChangePasswordResponse changePassword(ChangePasswordRequest request, RedirectAttributes attributes) {
        return null;
    }
}
