package com.portfolio.TellMeWhenApp.StorageProduct.Repository;

import com.portfolio.TellMeWhenApp.StorageProduct.Model.StorageProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageProductRepository extends JpaRepository<StorageProduct, Integer> {
}
