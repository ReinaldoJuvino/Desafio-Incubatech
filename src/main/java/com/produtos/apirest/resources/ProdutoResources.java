package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value = "API REST PRODUTOS")
//a o definir o origins como * defino que qualquer dominio pode acessar ess api
@CrossOrigin(origins = "*")//(origins = "http://dominio autorizado...")
public class ProdutoResources {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value = "Retona uma lista de produtos")
	public List<Produto> listarProdutos(){
		
		return produtoRepository.findAll();
		
	}
	
	//@pathVariable serve para pegar o id vindo da url e atribuilo como parametro para o id 
	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retona um produto pelo id indicado na requisição")
	public Produto listarProdutoUnico(@PathVariable(value = "id")   long id){
		
		return produtoRepository.findById(id);
		
	}
	
	@PostMapping("/produtos")
	@ApiOperation(value = "Adiciona um produto")
	public Produto salvarProduto(@RequestBody Produto produto) {
		
		return produtoRepository.save(produto);
	
	}
	
	@DeleteMapping("/produtos")
	@ApiOperation(value = "deleta produto")
	public void deletaProduto(@RequestBody Produto produto) {
		
		produtoRepository.delete(produto);
		
	}
	
	@PutMapping("/produtos")
	@ApiOperation(value = "Atualiza os produtos")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
		
	}
}
