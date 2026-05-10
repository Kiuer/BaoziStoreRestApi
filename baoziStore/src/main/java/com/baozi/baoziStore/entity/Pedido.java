package com.baozi.baoziStore.entity;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PEDIDO")
public class Pedido extends AbstractEntity<Long> {

	// ER cliente(fk) e pedido
	@ManyToOne
	@JoinColumn(name = "id_cliente_fk")
	private Cliente cliente;

	// ER Produto(fk) e pedido
	@ManyToOne
	@JoinColumn(name = "id_produto_fk")
	private Produto produto;

	@Column(nullable = false)
	private Integer quantidade;

	@Column(name = "data_pedido", nullable = false, columnDefinition = "DATE")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataPedido;

	public LocalDate getDataPedido() {
    	return dataPedido;}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;}

	public Cliente getCliente() {
		return cliente;}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;}

	public Produto getProduto() {
		return produto;}

	public void setProduto(Produto produto) {
    	this.produto = produto;}

	public Integer getQuantidade() {
		return quantidade;}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;}

	public String getNomeCliente() {
		return cliente != null ? cliente.getNome() : "";}

	public String getNomeProduto() {
		return produto != null ? produto.getNome() : "";}

	public void setProduto(String string) {	}

	public void setCliente(String string) {	}
}