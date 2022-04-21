package com.portfolio.TellMeWhenApp.Repository;

import com.portfolio.TellMeWhenApp.Entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    void findProductEntitiesById(Long id);
}
