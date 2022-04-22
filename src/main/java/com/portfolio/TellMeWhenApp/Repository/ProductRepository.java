package com.portfolio.TellMeWhenApp.Repository;

import com.portfolio.TellMeWhenApp.Model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
