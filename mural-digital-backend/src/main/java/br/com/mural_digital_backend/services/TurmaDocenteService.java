package br.com.mural_digital_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.mural_digital_backend.models.Cardapio;
import br.com.mural_digital_backend.models.NoticiaDocente;
import br.com.mural_digital_backend.models.TurmaDocente;
import br.com.mural_digital_backend.repository.NoticiaDocenteRepository;
import br.com.mural_digital_backend.repository.TurmaDocenteRepository;
import jakarta.validation.Valid;

@Service
public class TurmaDocenteService {
	
	@Autowired
	TurmaDocenteRepository turmaDocenteRepository;

	public Long cadastrarNoticia(@Valid  TurmaDocente noticiaDocente) throws Exception {
		if (noticiaDocente == null) {
			throw new Exception("Dados inválidos ou nulos");
		}
		
		try {
			TurmaDocente turmaDocenteCadastrar = turmaDocenteRepository.save(noticiaDocente);
			
			return turmaDocenteCadastrar.getId();
		} catch (Exception e) {
			throw new Exception("Ja existem um Noticia nesse dia");
		}

	}
	public Optional<TurmaDocente> searchTurmaDocente(Long id) throws Exception {

		Optional<TurmaDocente> turmaDocente;
		try {
			turmaDocente = turmaDocenteRepository.findById(id);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir");
		}
		if (turmaDocente == null) {
			throw new Exception("Noticia não existente");
		}
		try {
			return turmaDocenteRepository.findById(id);
		} catch (Exception e) {
			throw new Exception("ID Invalido");
		}
	}
	public String deleteTurmaDocente(Long id) throws Exception {
		Optional<TurmaDocente> turmaDocente;
		try {
			turmaDocente = turmaDocenteRepository.findById(id);
			if (turmaDocente.isEmpty()) {
				throw new Exception("Noticia não encontrado com ID: " + id);
			}
		} catch (Exception e) {
			throw new Exception("Noticia não encontrado com ID: " + id);
		}

		try {
			turmaDocenteRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir");
		}
		return "Registro de Noticia excluído com sucesso";

	}
	 public List<TurmaDocente> searchTurmaByServidorId(Long idServidor) {
	        return turmaDocenteRepository.findByLoginServidor_IdServidor(idServidor);
	    }
	 
	 
}
