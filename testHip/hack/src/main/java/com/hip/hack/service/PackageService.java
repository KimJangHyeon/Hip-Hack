package com.hip.hack.service;

import com.hip.hack.dao.PackageMapper;
import com.hip.hack.model.dto.PackageDTO;
import com.hip.hack.model.dto.ProductDTO;
import com.hip.hack.model.entity.Product;
import com.hip.hack.model.entity.ProductPackage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PackageService {
    private final PackageMapper packageMapper;
    ProductService productService;

    // 리스트 보여줌
    public List<PackageDTO> packageList() {
        List<Map<String, Object>> packages;
        packages = packageMapper.findAllPackage();
        List<PackageDTO> packageDTOS = new ArrayList<>();

        for (Map<String, Object> productPackage : packages) {
            ProductPackage pPackage = ProductPackage.builder()
                    .id((Integer) productPackage.get("id"))
                    .maxAccount((Integer) productPackage.get("max_account"))
                    .title((String)productPackage.get("title"))
                    .representationId((Integer) productPackage.get("representation_id"))
                    .build();

            Product product = productService.findByIdProduct(pPackage.getRepresentationId());
            packageDTOS.add(PackageDTO.builder()
                    .id(pPackage.getId())
                    .title(pPackage.getTitle())
                    .representation(ProductDTO.builder()
                            .imagePath(product.getImagePath())
                            .explain(product.getExplaination())
                            .build())
                    .totalPrice(pPackage.getMaxAccount())
                    .build());
        }
        return packageDTOS;
    }

    public PackageDTO packageDetail(int id) {
        //패키지 읽기
        Map<String, Object> productPackageMap = packageMapper.findById(id);
        System.out.println(productPackageMap);
        ProductPackage productPackage = ProductPackage.builder()
                .id((Integer) productPackageMap.get("id"))
                .maxAccount((Integer) productPackageMap.get("max_account"))
                .representationId((Integer) productPackageMap.get("representation_id"))
                .title((String) productPackageMap.get("title")).build();
        PackageDTO packageDTO = PackageDTO.builder()
                .id(productPackage.getId())
                .productDTOS(new ArrayList<>())
                .totalPrice(productPackage.getMaxAccount())
                .title(productPackage.getTitle())
                .build();

        // 패키지 id로 상품 읽기
        List<Product> products = productService.findByPackageProduct(id);
        List<ProductDTO> productDTOS = new ArrayList<>();
        products.forEach(p -> productDTOS.add(ProductDTO.builder()
                .id(p.getId())
                .explain(p.getExplaination())
                .imagePath(p.getImagePath())
                .price(p.getPrice())
                .userName(p.getUserName())
                .build()));

        //합치기
        for (ProductDTO productDTO : productDTOS) {
            packageDTO.getProductDTOS().add(productDTO);
        }
        return packageDTO;
    }

    // 사용자가 제품에 경매 ㄲ
    @Transactional
    public boolean postPackageDetail(PackageDTO packageDTO) {
        ProductPackage productPackage = ProductPackage
                .builder()
                .title(packageDTO.getTitle())
                .maxAccount(packageDTO.getTotalPrice())
                .build();
        packageMapper.create(productPackage);
        int packageId = productPackage.getId();
        for (ProductDTO productDTO : packageDTO.getProductDTOS()) {
            Product product = Product.builder()
                    .representation(productDTO.getRepresentation())
                    .packageId(packageId)
                    .explaination(productDTO.getExplain())
                    .userName(productDTO.getUserName())
                    .imagePath(productDTO.getImagePath())
                    .build();
            product = productService.create(product);
            if (productDTO.getRepresentation()) {
                productPackage.setRepresentationId(product.getId());
                System.out.println("LOG: " + productPackage);
                packageMapper.updateRepresentationId(productPackage);
            }
        }

        return true;
    }
}
