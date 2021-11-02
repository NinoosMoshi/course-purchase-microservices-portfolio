package com.ninos.apigatewaymicroservice3.controller;

import com.ninos.apigatewaymicroservice3.request.PurchaseServiceRequest;
import com.ninos.apigatewaymicroservice3.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/gateway/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseServiceRequest purchaseServiceRequest;

    @PostMapping// http://localhost:5555/gateway/purchase
    public ResponseEntity<?> savePurchase(@RequestBody Object purchase) {
        return new ResponseEntity<>(purchaseServiceRequest.savePurchase(purchase), HttpStatus.CREATED);
    }

    @GetMapping// http://localhost:5555/gateway/purchase
    public ResponseEntity<?> getAllPurchasesOfAuthorizedUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return ResponseEntity.ok(purchaseServiceRequest.getAllPurchasesOfUser(userPrincipal.getId()));
    }
}
