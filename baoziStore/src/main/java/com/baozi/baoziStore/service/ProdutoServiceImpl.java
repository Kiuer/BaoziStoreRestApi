package com.baozi.baoziStore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baozi.baoziStore.dao.ProdutoDao;
import com.baozi.baoziStore.entity.Produto;

@Service
@Transactional(readOnly = false)
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoDao dao;

	@Override
	public void salvar(Produto produto) {
		if (produto.getId() == null) {
			dao.save(produto);}
		else {           
			dao.update(produto);}
    }

	@Override
	public void excluir(Long id) {
		dao.delete(id);}

	@Override
	@Transactional(readOnly = true)
	public Produto buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Produto> buscaTodos() {
	return dao.findAll();}
}