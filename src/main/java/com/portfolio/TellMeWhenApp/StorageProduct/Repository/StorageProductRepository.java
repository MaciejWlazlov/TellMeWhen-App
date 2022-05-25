package com.portfolio.TellMeWhenApp.StorageProduct.Repository;

import com.portfolio.TellMeWhenApp.StorageProduct.Model.StorageProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface StorageProductRepository extends JpaRepository<StorageProduct, Integer> {

    List<StorageProduct> findTop3ByExpiryDateAfter(LocalDate expiryDate);
}
