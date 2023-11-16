package com.projetoGerenciamentoDePedidos.controller;

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

import com.projetoGerenciamentoDePedidos.entities.Produto;
import com.projetoGerenciamentoDePedidos.service.ProdutoService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "pedido", description = "API REST DE GERENCIAMENTO DE PEDIDO")
@RestController
@RequestMapping("/produto")
public class ProdutoController {
	private final ProdutoService produtoService;

	@Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/{id}")
   
    public ResponseEntity<Produto> buscaProdutoControlId (@PathVariable Long id){
    	Produto produto = produtoService.buscaProdutoId(id);
    	if(produto != null) {
    		return ResponseEntity.ok(produto);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    @GetMapping("/")
   
    public ResponseEntity<List<Produto>> buscaTodosProdutosControl(){
    	List<Produto> produto = produtoService.buscaTodosProdutos();
    	return ResponseEntity.ok(produto);
    }
    @PostMapping("/")
   
    public ResponseEntity<Produto> salvaProdutoControl(@RequestBody @Valid Produto produto){
    	Produto salvaProduto = produtoService.saveProduto(produto);
    	return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduto);
    }
    @PutMapping("/{id}")
   
    public ResponseEntity<Produto> alterarProdutoControl(@PathVariable Long id, @RequestBody @Valid Produto produto){
    	Produto alterarProduto = produtoService.alterarProduto(id, produto);
    	if (alterarProduto != null) {
    		return ResponseEntity.ok(produto);
    	}
    	else {
    		return ResponseEntity.notFound().build();
    	}
    }
    @DeleteMapping("/{id}")
    
    public ResponseEntity<String> apagaProdutoControl(@PathVariable Long id){
    	boolean apagar = produtoService.apagarProduto(id);
    	if(apagar) {	
    		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    	}
    	else {
    		return ResponseEntity.notFound().build();    	
    	}
    }
}

