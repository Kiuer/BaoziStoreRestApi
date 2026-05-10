package com.baozi.baoziStore.dao;

import java.util.List;

import com.baozi.baoziStore.entity.*;

public interface PedidoDao {
	void save(Pedido pedido);
	void update(Pedido pedido);
	void delete(Long id);
	Pedido findById(Long id);
	List<Pedido> findAll();
}