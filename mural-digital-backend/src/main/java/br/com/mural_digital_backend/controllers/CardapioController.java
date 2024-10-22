package br.com.mural_digital_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mural_digital_backend.dtos.CardapioDTO;
import br.com.mural_digital_backend.models.Cardapio;
import br.com.mural_digital_backend.services.CardapioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/cardapio")
public class CardapioController {

	@Autowired
	private CardapioService cardapioService;

	    @PostMapping
	    public ResponseEntity<Object> addBuyer(@Valid @RequestBody Cardapio cardapio) {
	        try {
	            return ResponseEntity.ok(cardapioService.addCardapio(cardapio));
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Ocorreu um erro: " + e.getMessage()); // Retorna a mensagem de erro
	        }
	    }

}
