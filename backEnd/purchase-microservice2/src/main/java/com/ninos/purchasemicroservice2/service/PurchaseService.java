package com.ninos.purchasemicroservice2.service;

import com.ninos.purchasemicroservice2.model.Purchase;

import java.util.List;

public interface PurchaseService {

    Purchase savePurchase(Purchase purchase);

    List<Purchase> findAllPurchasesOfUser(Long userId);


}
