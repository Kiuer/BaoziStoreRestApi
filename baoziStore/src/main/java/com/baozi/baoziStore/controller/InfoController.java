package com.baozi.baoziStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.baozi.baoziStore.entity.Cliente;
import com.baozi.baoziStore.entity.Pedido;
import com.baozi.baoziStore.entity.Produto;
import com.baozi.baoziStore.service.PedidoService;
import com.baozi.baoziStore.service.ProdutoService;
import com.baozi.baoziStore.service.ClienteService;

@Controller
@RequestMapping("/info")
public class InfoController {

	@Autowired
	private PedidoService service;    
	@Autowired
	private ProdutoService produtoService; 
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/cadastro")
	public String cadastro(Pedido pedido, Produto produto, Cliente cliente, ModelMap model) {
	// logicas para edicao e criacao
		// pedidos:
		model.addAttribute("pedido", (pedido == null || pedido.getId() == null) ? new Pedido() : pedido);
		// produtos:
		model.addAttribute("produto", (produto == null || produto.getId() == null) ? new Produto() : produto);
		// clientes
		model.addAttribute("cliente", (cliente == null || cliente.getId() == null) ? new Cliente() : cliente);

		model.addAttribute("produtos", produtoService.buscaTodos());
		model.addAttribute("clientes", clienteService.buscaTodos());
		return "info/cadastro";}

	@GetMapping("/produto/editar/{id}")
	public String preEditarProduto(@PathVariable("id") Long id, ModelMap model) {
		// edicao produto
		return cadastro(null, produtoService.buscarPorId(id), null, model);}

	@GetMapping("/produto/excluir/{id}")
	public String excluirProduto(@PathVariable("id") Long id, RedirectAttributes attr) {
	// validacao e exclusao produto:
		try {
			produtoService.excluir(id);
			attr.addFlashAttribute("success", "Produto removido com sucesso.");}
		catch (Exception e) {
			attr.addFlashAttribute("fail", "Erro: O produto possui pedidos vinculados.");}
	return "redirect:/info/cadastro";}

	@GetMapping("/cliente/editar/{id}")
	public String preEditarCliente(@PathVariable("id") Long id, ModelMap model) {
	// edicao cliente
	return cadastro(null, null, clienteService.buscarPorId(id), model);}

	@GetMapping("/cliente/excluir/{id}")
	public String excluirCliente(@PathVariable("id") Long id, RedirectAttributes attr) {
	// validacao e exclusao cliente:
		try {
			clienteService.excluir(id);
            attr.addFlashAttribute("success", "Cliente removido com sucesso.");}
		catch (Exception e) {
			attr.addFlashAttribute("fail", "Erro: O cliente possui pedidos ativos.");}
        return "redirect:/info/cadastro";}

    @GetMapping("/consulta") 
    public String consulta (ModelMap model) {
        model.addAttribute("pedidos", service.buscaTodos());
        return "info/consulta";}
    
    @PostMapping("/salvar")
    public String salvar(Pedido pedido, RedirectAttributes attr) {
    // validacao e adicao pedido:
        try {
            service.salvar(pedido);
            attr.addFlashAttribute("success", "Pedido processado!");
        } catch (RuntimeException e) {
            attr.addFlashAttribute("fail", e.getMessage());
            return "redirect:/info/cadastro"; 
        }
        return "redirect:/info/consulta";}
    
    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        return cadastro(service.buscarPorId(id), null, null, model);}

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        service.excluir(id);
        return "redirect:/info/consulta";}
}