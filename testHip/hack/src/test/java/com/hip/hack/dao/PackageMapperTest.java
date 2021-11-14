package com.hip.hack.dao;

import com.hip.hack.model.entity.ProductPackage;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
class PackageMapperTest {
    @Autowired
    PackageMapper packageMapper;

    @Test
    void findAllPackageTest() {
        System.out.println(packageMapper.findAllPackage());
    }

    @Test
    void ProductPackagecreateTest() {
        ProductPackage productPackage = ProductPackage.builder().maxAccount(20000).title("패키지 재목").build();
        packageMapper.create(productPackage);
        System.out.println(productPackage.getId());
    }

}