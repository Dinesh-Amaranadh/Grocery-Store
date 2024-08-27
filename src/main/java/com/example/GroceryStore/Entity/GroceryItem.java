package com.example.GroceryStore.Entity;

import jakarta.persistence.*;



@Entity
public class GroceryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private GroceryCategory groceryCategory;

    @Column(nullable = false, unique = true)
    private String itemName;

    @Column(nullable = false)
    private int weight;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private boolean inStock;

    // Getters and Setters

    public GroceryCategory getGroceryCategory() {
        return groceryCategory;
    }

    public void setGroceryCategory(GroceryCategory groceryCategory) {
        this.groceryCategory = groceryCategory;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}

