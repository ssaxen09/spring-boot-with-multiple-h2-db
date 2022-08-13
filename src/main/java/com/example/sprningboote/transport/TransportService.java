package com.example.sprningboote.transport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransportService {
	@Autowired
	private RotaRepository rotaRepository;

	public Rota addRota(Rota rota) {
		return rotaRepository.save(rota);
	}

	public Optional<Rota> findRota(Long id) {
		return rotaRepository.findById(id);
	}

}
