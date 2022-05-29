package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entity.OrderEntity;
import com.ecommerce.ecommerce.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    @Query(value = "select * from product p where product_colour_variant like :productColourVariant% and name like :productName% and category like :category% LIMIT 1" , nativeQuery = true)
    ProductEntity checkProduct(String productName, String category, String productColourVariant);
}
