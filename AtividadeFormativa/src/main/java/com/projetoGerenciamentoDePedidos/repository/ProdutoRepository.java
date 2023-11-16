package com.projetoGerenciamentoDePedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoGerenciamentoDePedidos.entities.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Long>{

}
