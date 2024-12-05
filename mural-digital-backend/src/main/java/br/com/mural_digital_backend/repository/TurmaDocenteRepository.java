package br.com.mural_digital_backend.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mural_digital_backend.models.TurmaDocente;

import java.util.List;

@Repository
public interface TurmaDocenteRepository extends JpaRepository<TurmaDocente, Long>{

	List<TurmaDocente> findByLoginServidor_IdServidor(Long id);

}
