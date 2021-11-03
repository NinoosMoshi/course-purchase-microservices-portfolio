package com.ninos.apigatewaymicroservice3.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "purchase-service"   //Name of purchase microservice in application.properties
        , path = "/api/purchase"          //Pre-path for purchase-service
        //,url = "${purchase.service.url}"  // in gateway application.properties  http://localhost:4444
        ,configuration = FeignConfiguration.class)
public interface PurchaseServiceRequest {

    @PostMapping // http://localhost:4444/api/purchase
    Object savePurchase(@RequestBody Object requestBody);

    @GetMapping("{userId}")  // http://localhost:4444/api/purchase/{userId}
    List<Object> getAllPurchasesOfUser(@PathVariable("userId") Long userId);

}
