package com.hip.hack.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Id;
import java.util.List;

@ToString
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PackageDTO {
    @Id
    private Integer id;
    private String title;
    private ProductDTO representation;
    private List<ProductDTO> productDTOS; //image path
    private Integer totalPrice;
}
