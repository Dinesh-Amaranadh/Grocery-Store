package com.example.GroceryStore.Repository;


import com.example.GroceryStore.Entity.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Integer> {
}

