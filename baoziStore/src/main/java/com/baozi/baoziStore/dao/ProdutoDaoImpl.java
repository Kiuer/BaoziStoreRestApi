package com.baozi.baoziStore.dao;

import org.springframework.stereotype.Repository;
import com.baozi.baoziStore.entity.Produto;

@Repository
public class ProdutoDaoImpl extends AbstractDao<Produto, Long> implements ProdutoDao {
}