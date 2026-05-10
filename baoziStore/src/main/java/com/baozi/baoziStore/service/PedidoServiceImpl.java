package com.baozi.baoziStore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baozi.baoziStore.dao.PedidoDao;
import com.baozi.baoziStore.entity.Pedido;
import com.baozi.baoziStore.entity.Produto;

@Service
@Transactional(readOnly = false)
public class PedidoServiceImpl implements PedidoService {
    
	@Autowired
	private PedidoDao dao;

	@Autowired
	private ProdutoService produtoService;

	@Override
	public void salvar(Pedido pedido) {
		// valida cliente
		if (pedido.getCliente() == null || pedido.getCliente().getId() == null) {
			throw new RuntimeException("Falha: não possuímos cadastro para este cliente.");}
        
		// valida estoque
		if (pedido.getProduto() == null || pedido.getProduto().getId() == null) {
			throw new RuntimeException("Falha: produto sem estoque.");}

		// valida produto
			Produto produtoDB = produtoService.buscarPorId(pedido.getProduto().getId());
		if (produtoDB == null) {
			throw new RuntimeException("Falha: produto inválido.");}

		if (Boolean.FALSE.equals(produtoDB.getEstoque())) {
			throw new RuntimeException("Erro: O produto " + produtoDB.getNome() + " está fora de estoque.");}

		if (pedido.getId() == null) dao.save(pedido);
	else dao.update(pedido);}
	
	@Override
	public void editar(Pedido pedido) {
		dao.update(pedido);}

	@Override
	public void excluir(Long id) {
		dao.delete(id);}

	@Override
	@Transactional(readOnly = true)
	public Pedido buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pedido> buscaTodos() {
	return dao.findAll();}
}