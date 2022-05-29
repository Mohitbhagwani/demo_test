package com.ecommerce.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class OrderDTO {
    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("category")
    private String category;
    @JsonProperty("productColourVariant")
    private String productColourVariant;

    @JsonProperty("buyer_name")    private String buyerName;
    @JsonProperty("contact_number")
    private Long contactNumber;
    @JsonProperty("buyer_address")
    private String buyerAddress;
}
