package com.baozi.baoziStore.service;

import java.util.List;
import com.baozi.baoziStore.entity.Produto;

public interface ProdutoService {
	void salvar(Produto produto);
	void excluir(Long id);
	Produto buscarPorId(Long id);
	List<Produto> buscaTodos();
}