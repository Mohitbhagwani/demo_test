package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.service.order.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@Slf4j
@AllArgsConstructor
public class MainController {

    @Autowired
    BeanFactory beanFactory;
    @Autowired
    OrderService orderService;
    @GetMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestParam("product_name") String productName,@RequestParam("category") String category,@RequestParam("productColourVariant") String productColourVariant,@RequestParam("address") String address) {
        ResponseEntity<Object> responseEntity;

        try {
            Object result = orderService.createOrder(productName, category, productColourVariant, address);

            responseEntity = new ResponseEntity<>( HttpStatus.OK);
        } catch (Exception e) {
            log.info("companySearch..",e.getMessage());

            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
