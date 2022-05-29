package com.ecommerce.ecommerce.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductDTO {


    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("category")
    private String category;
    @JsonProperty("productColourVariant")
    private String productColourVariant;

    @JsonProperty("stokeQuantity")
    private Long stokeQuantity;
    @JsonProperty("price")
    private Long price;
}
