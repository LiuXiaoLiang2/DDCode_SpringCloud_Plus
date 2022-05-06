package com.ddcode.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private Integer id;

    private String desc;

    private Double price;
}
