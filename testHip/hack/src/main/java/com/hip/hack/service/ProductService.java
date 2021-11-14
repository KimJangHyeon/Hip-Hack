package com.hip.hack.service;

import com.hip.hack.dao.ProductMapper;
import com.hip.hack.model.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;

    public Product create(Product product) {
        productMapper.createProduct(product);
        return product;
    }

    public List<Product> findByPackageProduct(int packageId) {
        return productMapper.findByPackageProduct(packageId);
    }

    public Product findByIdProduct(int id) {
        return productMapper.findByIdProduct(id);
    }

    public Boolean updatePriceAndName(int id, int price, String name) {
        Product product = Product.builder()
                .id(id)
                .price(price)
                .userName(name).build();
        productMapper.updatePriceAndName(product);
        return true;
    }

    public void deleteById(int id) {
        productMapper.deleteById(id);
    }
}
