package com.hip.hack.controller;

import com.hip.hack.model.dto.PackageDTO;
import com.hip.hack.model.dto.ProductDTO;
import com.hip.hack.service.PackageService;
import com.hip.hack.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PackageController {
    @Value("${spring.mock}")
    private boolean mock;
    private PackageService packageService;
    private ProductService productService;

    public PackageController(PackageService packageService, ProductService productService) {
        this.packageService = packageService;
        this.productService = productService;
    }


    @GetMapping("/list")
    public List<PackageDTO> productPackageList() {
        if (mock) {
            List<PackageDTO> packageDTOS = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                PackageDTO packageDTO = PackageDTO.builder()
                        .id(i)
                        .title("제목" + i)
                        .totalPrice(i * 10000)
                        .build();
                packageDTOS.add(packageDTO);
            }
            return packageDTOS;
        }
        return packageService.packageList();
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
        return packageService.packageDetail(packageId);
    }

    @PostMapping("/package")
    public boolean postPackageDetail(@RequestBody PackageDTO packageDTO) {
        return packageService.postPackageDetail(packageDTO);
    }

    @PutMapping("/product/{id}/{price}/{name}")
    public Boolean updateProductPrice(@PathVariable int id, @PathVariable int price, @PathVariable String name) {
        // 상품의 가격 설정
        // 패키지의 가격 업데이트
        // 패키지 전체 가격
        return productService.updatePriceAndName(id, price, name);
    }


}
