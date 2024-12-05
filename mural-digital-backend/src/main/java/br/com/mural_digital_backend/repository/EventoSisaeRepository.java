package br.com.mural_digital_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mural_digital_backend.models.Cardapio;
import br.com.mural_digital_backend.models.EventosSisae;
@Repository
public interface EventoSisaeRepository extends JpaRepository<EventosSisae, Long>{
	
}
