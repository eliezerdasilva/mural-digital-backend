package br.com.mural_digital_backend.controllers;

import java.io.IOException;
import java.sql.SQLException;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.mural_digital_backend.models.Cardapio;
import br.com.mural_digital_backend.models.EventosSisae;
import br.com.mural_digital_backend.services.CardapioService;
import br.com.mural_digital_backend.services.EventosSisaeService;
import jakarta.validation.Valid;


@CrossOrigin(origins = "http://127.0.0.1:3000")





@RestController
@RequestMapping("/api/sisae")
public class EventoSisaeController {
	
	
	@Autowired
    EventosSisaeService eventosSisaeService;



    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrarMidia(@RequestBody @Valid EventosSisae eventosSisae) {
        try {
            // Extrair os dados do evento
            String titulo = eventosSisae.getTitulo();
            String mensagem = eventosSisae.getMensagem();
            byte[] imagemBase64 = eventosSisae.getImagem();

            // Criar uma nova instância de EventosSisae
            EventosSisae eventos = new EventosSisae();
            eventos.setTitulo(titulo);
            eventos.setMensagem(mensagem);
            eventos.setImagem(imagemBase64);

            // Salvar no banco de dados
            eventosSisaeService.save(eventos);

            // Resposta de sucesso
            return ResponseEntity.ok().body(new ApiResponse("Mídia cadastrada com sucesso!", eventos.getId()));
        } catch (Exception e) {
            e.printStackTrace();
            // Resposta de erro
            return ResponseEntity.status(500).body(new ApiResponse("Erro ao cadastrar a mídia.", null));
        }
    }

    
    static class ApiResponse {
        private String message;
        private Long id;

        public ApiResponse(String message, Long id) {
            this.message = message;
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public Long getId() {
            return id;
        }
    }   
	

	@GetMapping("/listAll")
	public ResponseEntity<List<EventosSisae>> listEventos() {
		try {
			
			 List<EventosSisae> eventosSisae = eventosSisaeService.listAllEvetosSisae();
			  
			 if (!eventosSisae.isEmpty()) { return ResponseEntity.ok(eventosSisae); } else {
			  return ResponseEntity.noContent().build(); }
			 
		
		} catch (Exception e) {

			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> findEventosById(@PathVariable Long id) {
		try {
			Optional<EventosSisae> eventosSisae = eventosSisaeService.searchAnEventoSisaeById(id);

			if (eventosSisae != null) {
				return ResponseEntity.ok(eventosSisae);
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (Exception e) {

			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteEventos(@PathVariable Long id) throws Exception {
		try {
			String message = eventosSisaeService.deleteEventoSisae(id);
			return ResponseEntity.ok(message);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao excluir o registro de cardápio: " + e.getMessage());
		}

	}/*
		 * @PutMapping public ResponseEntity<Object> updateBuyer(@Valid @RequestBody
		 * Cardapio cardapio) throws Exception { Optional<Cardapio> cardapioSearch =
		 * cardapioService.searchAnCardapioById(cardapio.getId()); if (cardapioSearch ==
		 * null) { return ResponseEntity.notFound().build(); } try { return
		 * ResponseEntity.ok(cardapioService.save(cardapio)); } catch (IOException e) {
		 * 
		 * return ResponseEntity.badRequest().body("Erro de I/O: " + e.getMessage()); }
		 * catch (SQLException e) {
		 * 
		 * return
		 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro de SQL: "
		 * + e.getMessage()); } catch (Exception e) { return
		 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
		 * .body("Ocorreu um erro inesperado: " + e.getMessage()); }
		 * 
		 * }
		 */

}
