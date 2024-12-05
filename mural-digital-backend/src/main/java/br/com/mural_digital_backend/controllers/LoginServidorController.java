package br.com.mural_digital_backend.controllers;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mural_digital_backend.models.Cardapio;
import br.com.mural_digital_backend.models.TipoServidor;
import br.com.mural_digital_backend.models.Turma;
import br.com.mural_digital_backend.services.CardapioService;
import br.com.mural_digital_backend.services.LoginServidorService;

@RestController
@RequestMapping(value = "/api/login")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class LoginServidorController {

	@Autowired
	private LoginServidorService loginServidorService;

	 @GetMapping("/consultar")
	    public TipoServidor consultarTipoServidor(@RequestParam String email) {
	        return loginServidorService.getTipoServidorByEmail(email);
	    }


}
