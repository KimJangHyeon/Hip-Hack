package com.hip.hack.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import java.sql.Timestamp;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductPackage {
    @Id
    private Integer id;
    private Integer maxAccount;
    private Integer representationId;
    private String title;
}
