package br.com.mural_digital_backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mural_digital_backend.models.Cardapio;
import br.com.mural_digital_backend.models.NoticiaDocente;
import br.com.mural_digital_backend.services.NoticiaDocenteService;

@RestController
@RequestMapping(value = "/api/NoticiaDocente")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class NoticiaDocenteController {
	
	@Autowired
	private NoticiaDocenteService noticiaDocenteService;
	
	@PostMapping
	public ResponseEntity<Object> addNoticia(@RequestBody NoticiaDocente noticiaDocente) {
		

		try {
			return ResponseEntity.ok(noticiaDocenteService.cadastrarNoticia(noticiaDocente));

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro: " + e.getMessage());
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object>  listNoticia( @PathVariable long id) {
		try {
			Optional<NoticiaDocente> noticiaDocente = noticiaDocenteService.searchNoticiaDocenteId(id);

			if (noticiaDocente != null) {
				return ResponseEntity.ok(noticiaDocente);
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (Exception e) {

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteNoticiaDocente(@PathVariable Long id) throws Exception {
		try {
			String message = noticiaDocenteService.deleteNoticiaDocente(id);
			return ResponseEntity.ok(message);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao excluir o registro de cardápio: " + e.getMessage());
		}

	}

}
