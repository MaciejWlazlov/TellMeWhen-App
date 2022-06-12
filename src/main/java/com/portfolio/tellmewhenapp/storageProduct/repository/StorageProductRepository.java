package com.portfolio.tellmewhenapp.storageProduct.repository;

import com.portfolio.tellmewhenapp.storageProduct.model.Entity.StorageProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface StorageProductRepository extends JpaRepository<StorageProduct, Integer> {

    List<StorageProduct> findFirst5ByExpiryDateBetweenOrderByExpiryDate(LocalDate todaysDate, LocalDate expiryDate);
}
