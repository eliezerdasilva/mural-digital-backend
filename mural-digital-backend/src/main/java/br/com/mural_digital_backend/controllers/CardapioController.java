package br.com.mural_digital_backend.controllers;

import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mural_digital_backend.models.Cardapio;
import br.com.mural_digital_backend.services.CardapioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/cardapio")
public class CardapioController {

	@Autowired
	private CardapioService cardapioService;
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	private static final Logger logger = Logger.getLogger(CardapioController.class.getName());

	@PostMapping
	public ResponseEntity<Object> addBuyer(@RequestBody Cardapio cardapio) {
		System.out.println("aquio");

		try {
			return ResponseEntity.ok(cardapioService.addCardapio(cardapio));

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro: " + e.getMessage());
		}
	}

	@GetMapping("/listAllCardapio")
	public ResponseEntity<List<Cardapio>> listCardapio() {
		try {
			List<Cardapio> cardapios = cardapioService.listAllCardapio();

			if (!cardapios.isEmpty()) {
				return ResponseEntity.ok(cardapios);
			} else {
				return ResponseEntity.noContent().build();
			}
		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> findCardapioById(@PathVariable Long id) {
		try {
			Optional<Cardapio> cardapio = cardapioService.searchAnCardapioById(id);

			if (cardapio != null) {
				return ResponseEntity.ok(cardapio);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/date/{date}")
	public ResponseEntity<List<Cardapio>> findByLessonDate(@PathVariable String date) throws ParseException {
		Date data = formatter.parse(date);

		try {

			List<Cardapio> cardapio = cardapioService.searchAnCardapioByDate(data);

			return ResponseEntity.ok(cardapio);
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteBuyer(@PathVariable Long id) throws Exception{
		try {
			String message  = cardapioService.deleteCardapio(id);
			  return ResponseEntity.ok(message);
		} catch (Exception e) {
			 return ResponseEntity.badRequest().body("Erro ao excluir o registro de cardápio: " + e.getMessage());
		}
		
	}

	@PutMapping
	public ResponseEntity<Object> updateBuyer(@Valid @RequestBody Cardapio cardapio) throws Exception {
		Optional<Cardapio> cardapioSearch = cardapioService.searchAnCardapioById(cardapio.getId());
		if (cardapioSearch == null) {
			return ResponseEntity.notFound().build();
		}
		try {
			return ResponseEntity.ok(cardapioService.save(cardapio));
		} catch (IOException e) {
			
			return ResponseEntity.badRequest().body("Erro de I/O: " + e.getMessage());
		} catch (SQLException e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro de SQL: " + e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu um erro inesperado: " + e.getMessage());
		}

	}

}