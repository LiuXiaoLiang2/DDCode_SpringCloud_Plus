package com.ddcode.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Order {

    private Integer id;

    private Product product;

    private String userName;

    private Date createTime;
}
