package com.dev.veroneze.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.veroneze.data.ProdutoCongeladoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoCongeladoEntity, Long> {

}
