package com.baozi.baoziStore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baozi.baoziStore.dao.ClienteDao;
import com.baozi.baoziStore.entity.Cliente;

@Service
@Transactional(readOnly = false)
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao dao;

	@Override
	public void salvar(Cliente cliente) {
		if (cliente.getId() == null) {
			dao.save(cliente);}
		else {
			dao.update(cliente);}
    }

    @Override
    public void excluir(Long id) {
    	dao.delete(id);
    }

	@Override
	@Transactional(readOnly = true)
	public Cliente buscarPorId(Long id) {
	return dao.findById(id);}

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> buscaTodos() {
	return dao.findAll();}
}