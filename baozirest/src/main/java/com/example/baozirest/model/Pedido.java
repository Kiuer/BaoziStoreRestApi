package com.example.baozirest.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Correção para Auto-Incremento
    private Long id;

    @Column(name = "data_pedido", nullable = false)
    private LocalDate dataPedido;

    @Column(nullable = false)
    private Integer quantidade;

    // Relacionamento com Cliente
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente_fk")
    private Cliente cliente;

    // Relacionamento com Produto
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_produto_fk")
    private Produto produto;

    // Construtores
    public Pedido() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public LocalDate getDataPedido() { return dataPedido; }
    public void setDataPedido(LocalDate dataPedido) { this.dataPedido = dataPedido; }
    
    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    
    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
}