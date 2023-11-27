package com.dev.veroneze.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.veroneze.data.ProdutoCongeladoEntity;
import com.dev.veroneze.service.ProdutoCongeladoService;

@RestController
@RequestMapping("/produto-congelado")
public class ProdutoCongeladoController {

    @Autowired
    ProdutoCongeladoService produtoCongeladoService;

    @GetMapping("/listar")
    public ResponseEntity<List> getAllProdutoCongelado() {
        List<ProdutoCongeladoEntity> produtos = produtoCongeladoService.listarTodosProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<ProdutoCongeladoEntity> getProdutoById(@PathVariable Long id) {
        ProdutoCongeladoEntity produto = produtoCongeladoService.getProdutoId(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<ProdutoCongeladoEntity> addProduto(@RequestBody ProdutoCongeladoEntity prod){
        var novoProduto = produtoCongeladoService.criarProduto(prod);
        return new ResponseEntity<ProdutoCongeladoEntity>(novoProduto, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ProdutoCongeladoEntity> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoCongeladoEntity produto) {
        var produtoAtualizado = produtoCongeladoService.atualizarProduto(id, produto);
        return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id) {
        produtoCongeladoService.deletarProduto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
