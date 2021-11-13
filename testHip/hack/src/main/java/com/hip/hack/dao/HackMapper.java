package com.hip.hack.dao;

import com.hip.hack.model.entity.ProductPackage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface HackMapper {
    List<ProductPackage> test();
}
