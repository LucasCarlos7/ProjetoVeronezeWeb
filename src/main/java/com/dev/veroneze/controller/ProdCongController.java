package com.dev.veroneze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev.veroneze.data.ProdutoCongeladoEntity;
import com.dev.veroneze.service.ProdutoCongeladoService;

@Controller
public class ProdCongController {
    @Autowired
    ProdutoCongeladoService produtoCongeladoService;

    @GetMapping("/criarProdutoCongForm")
    public String criarProdutoCongForm(Model model) {
        ProdutoCongeladoEntity prod = new ProdutoCongeladoEntity();
        model.addAttribute("produtoCongelado", prod);
        return "product";
    }

    @PostMapping("/salvarProdutoCong")
    public String salvarProdutoCong(@ModelAttribute("produtoCongelado") ProdutoCongeladoEntity prod, BindingResult result) {
        if (result.hasErrors()) {
            return "insert";
        }
        if (prod.getId()==null) {
            produtoCongeladoService.criarProduto(prod);
        } else {
            produtoCongeladoService.atualizarProduto(prod.getId(), prod);
        }
        return "redirect:/";
    }
}
