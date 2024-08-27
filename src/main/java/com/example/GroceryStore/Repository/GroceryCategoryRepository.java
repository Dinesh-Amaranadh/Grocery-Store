package com.example.GroceryStore.Repository;


import com.example.GroceryStore.Entity.GroceryCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryCategoryRepository extends JpaRepository<GroceryCategory, Integer> {
}

