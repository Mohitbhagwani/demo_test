package com.ecommerce.ecommerce.service.order;

import com.ecommerce.ecommerce.dto.request.OrderDTO;
import com.ecommerce.ecommerce.entity.OrderEntity;
import com.ecommerce.ecommerce.entity.ProductEntity;
import com.ecommerce.ecommerce.repository.OrderRepository;
import com.ecommerce.ecommerce.repository.ProductRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Slf4j
@Service
@PropertySource(value = "classpath:application.properties")
public class OrderService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    public Object createOrder(String productName, String category, String productColourVariant, String address) throws Exception {
        Long orderId = null;
        try {
            ProductEntity productEntity = productRepository.checkProduct(productName, category, productColourVariant);

            OrderDTO orderDTO = new OrderDTO();
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setBuyerAddress(address);
            orderEntity.setCategory(productEntity.getCategory());
            orderEntity.setProductName(productEntity.getProductName());
            orderEntity.setProductColourVariant(productEntity.getProductColourVariant());
            orderEntity.setProductId(productEntity.getProductId());
            String customerId = UUID.randomUUID().toString();
            orderEntity.setCustomerId(customerId);
            orderRepository.save(orderEntity);
            orderId = orderEntity.getOId();
        } catch (Exception ee) {
            log.info("error in get-aadhaar-details..",ee.getMessage());
        }

        return "Your Order number is" + orderId + "successfully generated."+"\nIt will be delivered to you sson via Cash on Delivery.";

    }}
