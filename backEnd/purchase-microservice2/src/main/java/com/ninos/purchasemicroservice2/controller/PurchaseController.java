package com.ninos.purchasemicroservice2.controller;

import com.ninos.purchasemicroservice2.model.Purchase;
import com.ninos.purchasemicroservice2.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {


    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }


    @PostMapping   // http://localhost:4444/api/purchase
    public ResponseEntity<?> savePurchase(@RequestBody Purchase purchase){
        Purchase purchase1 = purchaseService.savePurchase(purchase);
        return new ResponseEntity<>(purchase1, CREATED);
    }


    @GetMapping("/{userId}")  // http://localhost:4444/api/purchase/{userId}
    public ResponseEntity<?> getAllPurchasesOfUser(@PathVariable Long userId){
       List<Purchase> purchase = purchaseService.findAllPurchasesOfUser(userId);
       return ResponseEntity.ok(purchase);
    }











}
