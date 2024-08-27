package com.example.GroceryStore.controller;

import com.example.GroceryStore.Entity.GroceryItem;
import com.example.GroceryStore.Repository.GroceryCategoryRepository;
import com.example.GroceryStore.Repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class GroceryItemController {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Autowired
    private GroceryCategoryRepository groceryCategoryRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("items", groceryItemRepository.findAll());
        return "items/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new GroceryItem());
        model.addAttribute("categories", groceryCategoryRepository.findAll());
        return "items/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute GroceryItem item) {
        groceryItemRepository.save(item);
        return "redirect:/items";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable int id, Model model) {
        GroceryItem item = groceryItemRepository.findById(id).orElseThrow();
        model.addAttribute("item", item);
        return "items/details";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        GroceryItem item = groceryItemRepository.findById(id).orElseThrow();
        model.addAttribute("item", item);
        model.addAttribute("categories", groceryCategoryRepository.findAll());
        return "items/edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable int id, @ModelAttribute GroceryItem item) {
        groceryItemRepository.save(item);
        return "redirect:/items/" + id;
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        groceryItemRepository.deleteById(id);
        return "redirect:/items";
    }
}
