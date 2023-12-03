package com.dev.veroneze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev.veroneze.data.ProductEntity;
import com.dev.veroneze.service.ProductService;

@Controller
public class ProdController {
    @Autowired
    ProductService productService;

    @GetMapping("/createProductForm")
    public String createProductForm(Model model) {
        ProductEntity prod = new ProductEntity();
        model.addAttribute("product", prod);
        return "product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") ProductEntity prod) {
        productService.createProduct(prod);
        return "redirect:/";
    }
}
