package com.hip.hack.dao;

import com.hip.hack.model.entity.ProductPackage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
@Mapper
public interface PackageMapper {
    List<Map<String, Object>> findAllPackage();
    void create(ProductPackage productPackage);
    void updateRepresentationId(ProductPackage productPackage);
    Map<String, Object> findById(int id);
}
