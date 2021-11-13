package com.hip.hack.controller;

import com.hip.hack.model.dto.PackageDTO;
import com.hip.hack.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HackController {
    @Value("${spring.mock}")
    private boolean mock;

    @GetMapping("/list")
    public List<PackageDTO> ProductPackageList() {
        if (mock) {
            List<PackageDTO> packageDTOS = new ArrayList<>();
            for (int i = 0; i < 100000; i++) {
                List<ProductDTO> products = new ArrayList<>();
                for (int j = 0; j < 5; j++) {
                    products.add(ProductDTO.builder().imagePath("/image/imagepath" + j + ".jpg").build());
                }
                PackageDTO packageDTO = PackageDTO.builder()
                        .id(i)
                        .title("제목" + i)
                        .productDTOS(products)
                        .totalPrice(i * 10000)
                        .build();
                packageDTOS.add(packageDTO);
            }
            return packageDTOS;
        }
        return null;
    }

    @GetMapping("/package")
    public PackageDTO getPackageDetail(@RequestParam int packageId) {
        if (mock) {
            List<ProductDTO> products = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                products.add(ProductDTO.builder()
                        .explain(j + "번째 " + "설명입니다.")
                        .imagePath("/image/imagepath" + j + ".jpg")
                        .price(j * 10000)
                        .build());
            }
            return PackageDTO.builder()
                    .id(1)
                    .title("package title")
                    .productDTOS(products)
                    .totalPrice(10000)
                    .build();

        }
        return null;
    }

    @PutMapping("/product/{id}/{price}")
    public String updateProductPrice(@PathVariable int id, @PathVariable int price) {
        // 상품의 가격 설정
        // 패키지의 가격 업데이트
        // 패키지 전체 가격
        if (price > 10000) {
            return "package deleted";
        }
        else {
            return "update success";
        }
    }

    @PostMapping("/package")
    public PackageDTO postPackageDetail(@RequestBody PackageDTO packageDTO) {
        return null;
    }

}
