package com.hip.hack.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private Integer id;
    private Boolean representation;
    private Integer packageId;
    private String explaination;
    private String imagePath;
    private Integer price;
    private String userName;
}
