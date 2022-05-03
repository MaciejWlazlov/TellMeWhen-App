package com.portfolio.TellMeWhenApp.ShoppingList.Repository;

import com.portfolio.TellMeWhenApp.ShoppingList.Model.ShoppingProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingProductRepository extends JpaRepository<ShoppingProductEntity, Integer> {
}
