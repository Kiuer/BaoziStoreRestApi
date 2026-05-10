package com.baozi.baoziStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.baozi.baoziStore.entity.Produto;
import com.baozi.baoziStore.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
	//edicao
		model.addAttribute("produto", service.buscarPorId(id));
		return "info/cadastro"; }

	@PostMapping("/salvar")
	public String salvar(Produto produto, RedirectAttributes attr) {
	//adicao
		service.salvar(produto);
		attr.addFlashAttribute("success", "Produto processado com sucesso!");
	return "redirect:/info/cadastro";}
}