package com.dev.veroneze.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.veroneze.data.ProductEntity;
import com.dev.veroneze.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductEntity createProduct(ProductEntity prod) {
        prod.setId(null);
        productRepository.save(prod);
        return prod;
    }

    public ProductEntity updateProduct(Long prodId, ProductEntity produtoRequest) {
        ProductEntity prod = getProductId(prodId);
        prod.setOriginStockId(produtoRequest.getOriginStockId());
        prod.setOriginStockName(produtoRequest.getOriginStockName());
        prod.setName(produtoRequest.getName());
        prod.setDescription(produtoRequest.getDescription());
        prod.setPrice(produtoRequest.getPrice());
        prod.setQuantityInStock(produtoRequest.getQuantityInStock());
        prod.setReleaseDate(produtoRequest.getReleaseDate());
        return prod;
    }

    public ProductEntity getProductId(Long prodId) {
        return productRepository.findById(prodId).orElse(null);
    }

    public List<ProductEntity> listAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Long prodId) {
        ProductEntity prod = getProductId(prodId);
        productRepository.deleteById(prod.getId());
    }

}
