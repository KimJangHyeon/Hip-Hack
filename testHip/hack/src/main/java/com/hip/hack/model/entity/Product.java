package com.hip.hack.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Getter
@NoArgsConstructor
public class Product {
    @Id
    private Integer id;
    private String explanation;
    private String imagePath;
    private String price;
}
