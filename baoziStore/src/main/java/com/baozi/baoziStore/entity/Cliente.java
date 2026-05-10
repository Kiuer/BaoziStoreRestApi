package com.baozi.baoziStore.entity;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends AbstractEntity<Long> {
    @Column(nullable = false)
    private String nome;

    @Column(name = "cliente_desde", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate clienteDesde;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getClienteDesde() {
		return clienteDesde;
	}

	public void setClienteDesde(LocalDate clienteDesde) {
		this.clienteDesde = clienteDesde;
	}

    
    
}