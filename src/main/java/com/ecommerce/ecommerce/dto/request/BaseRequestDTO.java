package com.ecommerce.ecommerce.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseRequestDTO {


    @JsonProperty("data")
    private Object requestData;


}
