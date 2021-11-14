package com.hip.hack.service;

import com.hip.hack.model.dto.PackageDTO;
import com.hip.hack.model.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class PackageServiceTest {

    @Autowired
    PackageService packageService;


    @Test
    void lastTest() {
        System.out.println(packageService.packageDetail(1));
    }

    @Test
    void postPackageDetailTest() {
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            productDTOs.add(ProductDTO.builder()
                    .representation(false)
                    .explain("재품 설명입니다. " + i)
                    .imagePath("/image/image2.jpg")
                    .build());
        }
        productDTOs.add(ProductDTO.builder()
                .representation(true)
                .explain("재품 설명입니다. 5")
                .imagePath("/image/image2.jpg")
                .build());
        PackageDTO packageDTO = PackageDTO.builder()
                .title("패키지 재목")
                .totalPrice(20000)
                .productDTOS(productDTOs)
                .build();
        packageService.postPackageDetail(packageDTO);
    }

    @Test
    void packageListTest() {
        List<PackageDTO> packageDTOS = packageService.packageList();
        for (PackageDTO packageDTO : packageDTOS) {
            System.out.println("LOG: " + packageDTO.toString());
        }
    }
}