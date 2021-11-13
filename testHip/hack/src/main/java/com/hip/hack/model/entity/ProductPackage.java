package com.hip.hack.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@Builder
@Setter
@Getter
@AllArgsConstructor
public class ProductPackage {
    @Id
    private Integer id;
    private Integer productsId;
    private String title;
    private Integer maxAcount;
//    private Integer maxDate;
}
