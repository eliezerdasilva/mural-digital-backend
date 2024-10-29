package br.com.mural_digital_backend.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.mural_digital_backend.models.Cardapio;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {

	 void deleteById(Long id);
	 List<Cardapio> findByData(Date data);
	


}
