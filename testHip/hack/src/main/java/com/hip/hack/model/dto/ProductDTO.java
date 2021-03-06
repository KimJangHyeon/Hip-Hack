package com.hip.hack.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    private Integer id;
    private Boolean representation;
    private String explain;
//    private Integer packageId;
    private String userName;
    private String imagePath;
    private Integer price;
}
