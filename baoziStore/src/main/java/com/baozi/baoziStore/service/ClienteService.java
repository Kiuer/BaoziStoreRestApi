package com.baozi.baoziStore.service;

import java.util.List;
import com.baozi.baoziStore.entity.Cliente;

public interface ClienteService {
	void salvar(Cliente cliente);
	void excluir(Long id);
	Cliente buscarPorId(Long id);
	List<Cliente> buscaTodos();}