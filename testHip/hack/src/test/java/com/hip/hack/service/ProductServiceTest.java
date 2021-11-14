package com.hip.hack.service;

import com.hip.hack.model.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceTest {
    @Autowired
    ProductService service;

    @Test
    void create() {
        service.create(Product.builder()
                .packageId(10)
                .explaination("이것은 설명입니다?")
                .userName("김장현")
                .imagePath("/image/product2.jpg")
                .build());
    }

    @Test
    void findByPackageProductTest() {
        int packageId = 10;
        System.out.println(service.findByPackageProduct(packageId));
        return;
    }

    @Test
    void updatePriceAndNameTest() {
        Product product = Product
                .builder()
                .id(1)
                .userName("김창현")
                .price(1200)
                .build();
        service.updatePriceAndName(1, 1200, "김창현");
        System.out.println(product);
    }

    @Test
    void deleteById() {
        service.deleteById(1);
    }
}