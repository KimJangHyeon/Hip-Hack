package com.hip.hack.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class HackUser {
    private String name;
    private Integer currentPoint;
    private List<Integer> productId;
}
