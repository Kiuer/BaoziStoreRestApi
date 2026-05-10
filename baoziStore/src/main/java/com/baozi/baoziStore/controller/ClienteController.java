package com.baozi.baoziStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.baozi.baoziStore.entity.Cliente;
import com.baozi.baoziStore.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteService service;
    
	@PostMapping("/salvar")
	public String salvar(Cliente cliente, RedirectAttributes attr) {
		service.salvar(cliente);
		attr.addFlashAttribute("success", "Cliente cadastrado!");
		return "redirect:/info/cadastro";
    }
}