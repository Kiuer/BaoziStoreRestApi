package com.baozi.baoziStore.dao;

import java.util.List;
import com.baozi.baoziStore.entity.Produto;

public interface ProdutoDao {
	void save(Produto produto);
	void update(Produto produto);
	void delete(Long id);
	Produto findById(Long id);
	List<Produto> findAll();
}