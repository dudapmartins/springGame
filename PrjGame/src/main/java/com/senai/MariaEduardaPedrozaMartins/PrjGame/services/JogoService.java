package com.senai.MariaEduardaPedrozaMartins.PrjGame.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.MariaEduardaPedrozaMartins.PrjGame.entities.Jogo;
import com.senai.MariaEduardaPedrozaMartins.PrjGame.repository.JogoRepository;

@Service
public class JogoService {
	private final JogoRepository jogoRepository;

	public JogoService(JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}

	public Jogo saveJogo(Jogo jogo) {
		return jogoRepository.save(jogo);
	}

	public Jogo getJogoById(Long id) {
		return jogoRepository.findById(id).orElse(null);

	}

	public List<Jogo> getAllJogo() {
		return jogoRepository.findAll();
	}

	public void deleteJogo(Long id) {
		jogoRepository.deleteById(id);
	}

}
