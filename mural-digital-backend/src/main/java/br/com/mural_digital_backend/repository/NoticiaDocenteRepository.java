package br.com.mural_digital_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mural_digital_backend.models.Cardapio;
import br.com.mural_digital_backend.models.NoticiaDocente;

public interface NoticiaDocenteRepository extends JpaRepository<NoticiaDocente, Long> {

}
