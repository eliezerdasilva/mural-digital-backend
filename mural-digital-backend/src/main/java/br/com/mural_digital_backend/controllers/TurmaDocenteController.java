package br.com.mural_digital_backend.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mural_digital_backend.models.Cardapio;
import br.com.mural_digital_backend.models.TurmaDocente;
import br.com.mural_digital_backend.services.CardapioService;
import br.com.mural_digital_backend.services.TurmaDocenteService;
@RestController
@RequestMapping(value = "/api/TurmaDocente")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class TurmaDocenteController {
	@Autowired
	private TurmaDocenteService turmaDocenteService;


	@PostMapping
	public ResponseEntity<Object> addTurmaDocente(@RequestBody TurmaDocente turmaDocente) {
		

		try {
			return ResponseEntity.ok(turmaDocenteService.cadastrarNoticia(turmaDocente));

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro: " + e.getMessage());
		}
	}

	

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> findTurmaDocente(@PathVariable Long id) {
		try {
			Optional<TurmaDocente> turmaDocente = turmaDocenteService.searchTurmaDocente(id);

			if (turmaDocente != null) {
				return ResponseEntity.ok(turmaDocente);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/docente/{idServidor}")
	public ResponseEntity<List<TurmaDocente>> getTurmaByServidorId(@PathVariable Long idServidor) {
	    try {
	        List<TurmaDocente> turmaDocenteList = turmaDocenteService.searchTurmaByServidorId(idServidor);

	        if (!turmaDocenteList.isEmpty()) {
	            return ResponseEntity.ok(turmaDocenteList);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().build();
	    }
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteTurmaDocente(@PathVariable Long id) throws Exception {
		try {
			String message = turmaDocenteService.deleteTurmaDocente(id);
			return ResponseEntity.ok(message);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao excluir o registro de Turma Docente: " + e.getMessage());
		}

	}
}
