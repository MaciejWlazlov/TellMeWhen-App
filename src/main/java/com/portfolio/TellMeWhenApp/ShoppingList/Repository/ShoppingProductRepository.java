package com.portfolio.TellMeWhenApp.ShoppingList.Repository;

import com.portfolio.TellMeWhenApp.ShoppingList.Model.ShoppingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingProductRepository extends JpaRepository<ShoppingProduct, Integer> {
}
