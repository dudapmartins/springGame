package com.senai.MariaEduardaPedrozaMartins.PrjGame.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.MariaEduardaPedrozaMartins.PrjGame.entities.Jogo;
import com.senai.MariaEduardaPedrozaMartins.PrjGame.services.JogoService;


@RestController
@RequestMapping("/jogo")
public class JogoController {
	private final JogoService jogoService;

	public JogoController(JogoService jogoService) {
		this.jogoService = jogoService;
	}

	@PostMapping
	public Jogo createJogo(@RequestBody Jogo jogo) {
		return jogoService.saveJogo(jogo);
	}

	@GetMapping
	public List<Jogo> getAllJogo() {
		return jogoService.getAllJogo();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Jogo> getJogo(@PathVariable Long id) {
		Jogo jogo = jogoService.getJogoById(id);
		if (jogo != null) {
			return ResponseEntity.ok(jogo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/home")
	public String paginaInicial() {
		return "index";// nome do seu arquivo HTML (sem a extensão)
	}

	@DeleteMapping("/{id}")
	public void deleteJogo(@PathVariable Long id) {
		jogoService.deleteJogo(id);
	}

}
