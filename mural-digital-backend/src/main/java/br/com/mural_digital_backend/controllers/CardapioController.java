package br.com.mural_digital_backend.controllers;

import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class CardapioController {

	@Autowired
	private CardapioService cardapioService;
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	private static final Logger logger = Logger.getLogger(CardapioController.class.getName());

	
	 @PostMapping("/cadastrar")
	public ResponseEntity<Object> addCarpio(@RequestBody Cardapio cardapio) {
		

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
		System.out.println(data);

		try {

			List<Cardapio> cardapio = cardapioService.searchAnCardapioByDate(data);

			return ResponseEntity.ok(cardapio);
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteBuyer(@PathVariable Long id) throws Exception {
		try {
			String message = cardapioService.deleteCardapio(id);
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

	@GetMapping(value = "/week/{date}")
	public ResponseEntity<List<Cardapio>> findByWeek(@PathVariable String date) throws ParseException {
		
		LocalDate data = LocalDate.parse(date);

		List<Cardapio> listCardapioWeek = new ArrayList<>() ; 
			
			
		int i = 0;
		while (i < 5) {
			LocalDate proximoDia = data.plusDays(i);
			
			Date date1 = Date.from(proximoDia.atStartOfDay(ZoneId.systemDefault()).toInstant());
			i++;
			try {
				System.out.println(date1);
				Cardapio cardapio = cardapioService.searchAnCardapioByWeek(date1);
				listCardapioWeek.add(cardapio);
			} catch (Exception e) {
				
				e.printStackTrace();
			}

		}

		try {

			return ResponseEntity.ok(listCardapioWeek);
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}

}