package ru.lomov.lesson_7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.lomov.lesson_7.model.Product;
import ru.lomov.lesson_7.services.ProductService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @PostMapping("/products")
    public String save(@RequestParam String title, @RequestParam BigDecimal cost){
        Product product = Product.builder()
                .title(title)
                .cost(cost)
                .build();
        productService.save(product);
        return "redirect:/products";
    }
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id).get();
    }
    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }

}
