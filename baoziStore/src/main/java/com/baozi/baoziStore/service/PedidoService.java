package com.baozi.baoziStore.service;

import java.util.List;

import com.baozi.baoziStore.entity.Pedido;

public interface PedidoService {
	void salvar(Pedido pedido);
	void editar(Pedido pedido);
	void excluir(Long id);
	Pedido buscarPorId(Long id);
	List<Pedido> buscaTodos();}