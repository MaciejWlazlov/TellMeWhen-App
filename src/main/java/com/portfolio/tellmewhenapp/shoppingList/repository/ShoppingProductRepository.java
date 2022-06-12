package com.portfolio.tellmewhenapp.shoppingList.repository;

import com.portfolio.tellmewhenapp.shoppingList.entity.ShoppingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingProductRepository extends JpaRepository<ShoppingProduct, Integer> {
}
