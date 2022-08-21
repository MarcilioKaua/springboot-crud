package br.ifpe.web2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web2.model.Contato;
import br.ifpe.web2.model.ContatoDAO;

@Controller
public class ContatoController {
	
	private List<Contato> contatos = new ArrayList<>();
	@Autowired
	private ContatoDAO contatoDAO;
	
	//Exibir formulário de cadastrar
	@GetMapping("/exibirContato")
	public String exibirForm(Contato contato) {
		return "contatos-form";
	}
	
	//Recebe o objeto que vai ser cadastrado
	@PostMapping("/salvarContato")
	public String salvarContato(Contato contato) {
		this.contatoDAO.save(contato);
		return "redirect:/listarContatos";
	}
	
	//Listagem de contatos
	@GetMapping("/listarContatos")
	public String listarContatos(Model model) {
		model.addAttribute("lista", this.contatoDAO.findAll());
		return "contatos-list";
	}
	
	//Remover contatos
	@GetMapping("/removerContato")
	public String removerContato(String email) {
		Contato contatoParaRemover = null;
		contatoDAO.deleteById(email);
		return "redirect:/listarContatos";
	}
	
	//Editar contatos
	@GetMapping("/editarContato")
	public String editarContato(String email, Model model) {
		model.addAttribute("contato", this.contatoDAO.findById(email));
		return "contatos-form";
	}
}
