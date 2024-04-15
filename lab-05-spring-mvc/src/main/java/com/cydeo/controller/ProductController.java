package com.cydeo.controller;

import com.cydeo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search-product/{productName}")
    public String getProductList(Model model, @PathVariable String productName){

        model.addAttribute("productList",productService.searchProduct(productName));

        return "product/product-list";
    }


}
