package com.baozi.baoziStore.dao;

import java.util.List;
import com.baozi.baoziStore.entity.Cliente;

public interface ClienteDao {
    void save(Cliente cliente);
    void update(Cliente cliente);
    void delete(Long id);
    Cliente findById(Long id);
    List<Cliente> findAll();
}