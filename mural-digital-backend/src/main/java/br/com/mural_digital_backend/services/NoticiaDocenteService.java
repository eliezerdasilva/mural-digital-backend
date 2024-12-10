package br.com.mural_digital_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mural_digital_backend.models.Cardapio;
import br.com.mural_digital_backend.models.EventosSisae;
import br.com.mural_digital_backend.models.NoticiaDocente;
import br.com.mural_digital_backend.repository.NoticiaDocenteRepository;
import jakarta.validation.Valid;

@Service
public class NoticiaDocenteService {
	
	@Autowired
	NoticiaDocenteRepository noticiaDocenteRepository;

	public Long cadastrarNoticia(@Valid  NoticiaDocente noticiaDocente) throws Exception {
		if (noticiaDocente == null) {
			throw new Exception("Dados inválidos ou nulos");
		}
		
		try {
			NoticiaDocente noticiaDocenteCadastrado = noticiaDocenteRepository.save(noticiaDocente);
			
			return noticiaDocenteCadastrado.getId();
		} catch (Exception e) {
			throw new Exception("Ja existem um Noticia nesse dia");
		}

	}
	public Optional<NoticiaDocente> searchNoticiaDocenteId(Long id) throws Exception {

		Optional<NoticiaDocente> noticiaDocente;
		try {
			noticiaDocente = noticiaDocenteRepository.findById(id);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir");
		}
		if (noticiaDocente == null) {
			throw new Exception("Noticia não existente");
		}
		try {
			return noticiaDocenteRepository.findById(id);
		} catch (Exception e) {
			throw new Exception("ID Invalido");
		}
	}
	public String deleteNoticiaDocente(Long id) throws Exception {
		Optional<NoticiaDocente> noticiaDocente;
		try {
			noticiaDocente = noticiaDocenteRepository.findById(id);
			if (noticiaDocente.isEmpty()) {
				throw new Exception("Noticia não encontrado com ID: " + id);
			}
		} catch (Exception e) {
			throw new Exception("Noticia não encontrado com ID: " + id);
		}

		try {
			noticiaDocenteRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir");
		}
		return "Registro de Noticia excluído com sucesso";

	}
	public List<NoticiaDocente> listAllNoticiaDocente() {
		List<NoticiaDocente> noticiaDocente = noticiaDocenteRepository.findAll();

		return noticiaDocente;
	}
	
}
