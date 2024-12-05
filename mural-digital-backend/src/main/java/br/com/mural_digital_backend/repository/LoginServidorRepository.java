package br.com.mural_digital_backend.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import br.com.mural_digital_backend.models.LoginServidor;
import br.com.mural_digital_backend.models.TipoServidor;
import jakarta.persistence.Tuple;


@Repository
public interface LoginServidorRepository extends JpaRepository<LoginServidor, Long> {
	@Query("SELECT u.tipo_servidor FROM login_servidor u WHERE u.email = :email")
	ArrayList<LoginServidor> findTipoServidorByEmail(@Param("email") String email);

}
