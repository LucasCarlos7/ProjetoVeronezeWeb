package com.dev.veroneze.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.veroneze.data.ProdutoCongeladoEntity;
import com.dev.veroneze.repository.ProdutoRepository;

@Service
public class ProdutoCongeladoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoCongeladoEntity criarProduto(ProdutoCongeladoEntity prod) {
        prod.setId(null);
        produtoRepository.save(prod);
        return prod;
    }

    public ProdutoCongeladoEntity atualizarProduto(Long prodId, ProdutoCongeladoEntity produtoRequest) {
        ProdutoCongeladoEntity prod = getProdutoId(prodId);
        prod.setNome(produtoRequest.getNome());
        prod.setDescricao(produtoRequest.getDescricao());
        prod.setPreco(produtoRequest.getPreco());
        prod.setQuantidadeEmEstoque(produtoRequest.getQuantidadeEmEstoque());
        prod.setProporcao(produtoRequest.getProporcao());
        prod.setData(produtoRequest.getData());
        return prod;
    }

    public ProdutoCongeladoEntity getProdutoId(Long prodId) {
        return produtoRepository.findById(prodId).orElse(null);
    }

    public List<ProdutoCongeladoEntity> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public void deletarProduto(Long prodId) {
        ProdutoCongeladoEntity prod = getProdutoId(prodId);
        produtoRepository.deleteById(prod.getId());
    }

}
