package com.example.GroceryStore.controller;


import com.example.GroceryStore.Entity.GroceryCategory;
import com.example.GroceryStore.Repository.GroceryCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
public class GroceryCategoryController {

    @Autowired
    private GroceryCategoryRepository groceryCategoryRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("categories", groceryCategoryRepository.findAll());
        return "categories/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new GroceryCategory());
        return "categories/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute GroceryCategory category) {
        groceryCategoryRepository.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable int id, Model model) {
        GroceryCategory category = groceryCategoryRepository.findById(id).orElseThrow();
        model.addAttribute("category", category);
        return "categories/details";
    }
}
