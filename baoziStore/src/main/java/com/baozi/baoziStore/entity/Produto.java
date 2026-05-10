package com.baozi.baoziStore.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto extends AbstractEntity<Long> {
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal preco;

	@Column(nullable = false)
	private Boolean estoque;

	public String getNome() {
	return nome;}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;}

	public Boolean getEstoque() {
	return estoque;}

	public void setEstoque(Boolean estoque) {
	this.estoque = estoque;}  
}
