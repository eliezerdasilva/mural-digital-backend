package br.com.mural_digital_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mural_digital_backend.dtos.CardapioDTO;
import br.com.mural_digital_backend.models.Cardapio;
import br.com.mural_digital_backend.repository.CardapioRepository;
import jakarta.validation.Valid;

@Service
public class CardapioService {
	
	

	@Autowired
	CardapioRepository cardapioRepository;
	
	public Long addCardapio(@Valid Cardapio cardapio) throws Exception {
		if (cardapio == null) {
			throw new Exception("Dados inválidos ou nulos");
		}
		try {
			Long id = save(cardapio);
			return id;
		} catch (Exception e) {
			throw new Exception(e);
		}

	}
	public Long save(@Valid Cardapio cardapio) throws Exception {
		try {
			Cardapio created = cardapioRepository.save(cardapio);
			
			return created.getId();
		} catch (Exception e) {
			throw new Exception(e);
		}

	}


}
