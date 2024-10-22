package br.com.mural_digital_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mural_digital_backend.models.Cardapio;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {

}
