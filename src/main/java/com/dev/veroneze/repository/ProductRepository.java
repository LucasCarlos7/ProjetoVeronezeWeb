package com.dev.veroneze.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dev.veroneze.data.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    //Método para obter o próximo ID a ser gerado pelo banco de dados
    @Query(value="SELECT * FROM veroneze_db.product_seq", nativeQuery = true)
    Long findNextId();
    
}
