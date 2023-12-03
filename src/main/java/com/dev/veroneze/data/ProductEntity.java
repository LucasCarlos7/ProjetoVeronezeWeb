package com.dev.veroneze.data;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min=1, max = 2, message = "INFORME '1' PARA 'CONGELADO' OU '2' PARA 'DESIDRATADO' ")
    private Long originStockId;
    private String originStockName;
    @Size(min=3, message = "INFORME AO MENOS 3 CARACTERES PARA O CAMPO NOME")
    private String name;
    @Size(min=3, message = "INFORME AO MENOS 3 CARACTERES PARA O CAMPO DESCRIÇÃO")
    private String description;
    @NotBlank(message="PREÇO OBRIGATÓRIO")
    private Double price;
    private Double quantityInStock;
    @NotBlank(message="DATA OBRIGATÓRIO")
    private Date releaseDate;
}
