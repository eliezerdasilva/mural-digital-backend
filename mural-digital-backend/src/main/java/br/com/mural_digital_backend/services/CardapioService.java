package br.com.mural_digital_backend.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.mural_digital_backend.dtos.CardapioDTO;
import br.com.mural_digital_backend.models.Cardapio;
import br.com.mural_digital_backend.repository.CardapioRepository;
import jakarta.validation.Valid;

@Service
public class CardapioService {

	@Autowired
	CardapioRepository cardapioRepository;
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	public Long addCardapio(@Valid Cardapio cardapio) throws Exception {
		if (cardapio == null) {
			throw new Exception("Dados inválidos ou nulos");
		}
		SimpleDateFormat formatadorBR = new SimpleDateFormat("dd-MM-yyyy");
		String dataFormatadaBR = formatadorBR.format(cardapio.getData());

		Date data = formatter.parse(dataFormatadaBR);
		cardapio.setData(data);
		try {
			List<Cardapio> cardapioReturn = cardapioRepository.findByData(cardapio.getData());
			if (!cardapioReturn.isEmpty()) {
				throw new Exception("Ja existem um cardapio nesse dia");
			}
		} catch (Exception e) {
			throw new Exception("Ja existem um cardapio nesse dia");
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

	public Optional<Cardapio> searchAnCardapioById(Long id) throws Exception {

		Optional<Cardapio> cardapio;
		try {
			cardapio = cardapioRepository.findById(id);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir");
		}
		if (cardapio == null) {
			throw new Exception("Cliente não existente");
		}
		try {
			return cardapioRepository.findById(id);
		} catch (Exception e) {
			throw new Exception("ID Invalido");
		}
	}

	public Long updatCardapio(Cardapio cardapio) throws Exception {
		try {
			return save(cardapio);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public List<Cardapio> listAllCardapio() {

		List<Cardapio> cardapio = cardapioRepository.findAll();

		return cardapio;
	}

	public List<Cardapio> searchAnCardapioByDate(Date date) throws Exception {
		try {
			List<Cardapio> cardapio = cardapioRepository.findByData(date);
			return cardapio;

		} catch (Exception e) {
			return null;
		}

	}

	public String deleteCardapio(Long id) throws Exception {
		Optional<Cardapio> Cardapio;
		try {
			Cardapio = cardapioRepository.findById(id);
			if (Cardapio.isEmpty()) {
				throw new Exception("Cardápio não encontrado com ID: " + id);
			}
		} catch (Exception e) {
			throw new Exception("Cardápio não encontrado com ID: " + id);
		}

		try {
			cardapioRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir");
		}
		return "Registro de cardápio excluído com sucesso";

	}
	public Cardapio searchAnCardapioByWeek(Date date) throws Exception {
		try {
			List<Cardapio> cardapio =  cardapioRepository.findByData(date);
			
			return cardapio.get(0);

		} catch (Exception e) {
			return null;
		}

	}

}
