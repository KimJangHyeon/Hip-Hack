package com.hip.hack.dao;

import com.hip.hack.model.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {
    void createProduct(Product product);

    List<Product> findByPackageProduct(int packageId);
    Product findByIdProduct(int id);
    void updatePriceAndName(Product product);
    void deleteById(int id);
}
