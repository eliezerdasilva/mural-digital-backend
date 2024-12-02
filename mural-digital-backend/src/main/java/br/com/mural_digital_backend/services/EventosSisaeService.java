package br.com.mural_digital_backend.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mural_digital_backend.models.Cardapio;
import br.com.mural_digital_backend.models.EventosSisae;
import br.com.mural_digital_backend.repository.CardapioRepository;
import br.com.mural_digital_backend.repository.EventoSisaeRepository;
import jakarta.validation.Valid;
@Service
public class EventosSisaeService {
	
	@Autowired
	EventoSisaeRepository eventoSisaeRepository;
	
	public Long cadastrarEvento(@Valid EventosSisae eventoSisae) throws Exception {
		if (eventoSisae == null) {
			throw new Exception("Dados inválidos ou nulos");
		}
		
		try {
			EventosSisae eventoSisaeCadastrado = eventoSisaeRepository.save(eventoSisae);
			if (eventoSisaeCadastrado == null) {
				throw new Exception("Ja existem um cardapio nesse dia");
			}
			return eventoSisaeCadastrado.getId();
		} catch (Exception e) {
			throw new Exception("Ja existem um cardapio nesse dia");
		}

		

	}
	
	
	public List<EventosSisae> listAllEvetosSisae() {

		List<EventosSisae> eventosSisae = eventoSisaeRepository.findAll();

		return eventosSisae;
	}
	public Long save(@Valid EventosSisae eventoSisae) throws Exception {
		try {
			EventosSisae eventoSisaeCadastrado = eventoSisaeRepository.save(eventoSisae);

			return eventoSisaeCadastrado.getId();
		} catch (Exception e) {
			throw new Exception(e);
		}

	}
	
	public Optional<EventosSisae> searchAnEventoSisaeById(Long id) throws Exception {

		Optional<EventosSisae> eventosSisae;
		try {
			eventosSisae = eventoSisaeRepository.findById(id);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir");
		}
		if (eventosSisae == null) {
			throw new Exception("Cliente não existente");
		}
		try {
			return eventoSisaeRepository.findById(id);
		} catch (Exception e) {
			throw new Exception("ID Invalido");
		}
	}
	public String deleteEventoSisae(Long id) throws Exception {
		Optional<EventosSisae> eventosSisae;
		try {
			eventosSisae = eventoSisaeRepository.findById(id);
			if (eventosSisae.isEmpty()) {
				throw new Exception("Cardápio não encontrado com ID: " + id);
			}
		} catch (Exception e) {
			throw new Exception("Cardápio não encontrado com ID: " + id);
		}

		try {
			eventoSisaeRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir");
		}
		return "Registro de cardápio excluído com sucesso";

	}
}
