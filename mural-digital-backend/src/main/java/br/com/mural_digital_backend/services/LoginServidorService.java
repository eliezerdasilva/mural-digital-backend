package br.com.mural_digital_backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Service;

import br.com.mural_digital_backend.models.EventosSisae;
import br.com.mural_digital_backend.models.LoginServidor;
import br.com.mural_digital_backend.models.TipoServidor;
import br.com.mural_digital_backend.repository.LoginServidorRepository;
import jakarta.persistence.Tuple;

@Service
public class LoginServidorService {

	@Autowired
	LoginServidorRepository loginServidorRepository;

	public TipoServidor getTipoServidorByEmail(String email) {
		ArrayList<LoginServidor> servidor = loginServidorRepository.findTipoServidorByEmail(email);
		if(!servidor.isEmpty()) {
			return servidor.get(0).getTipoServidor();
		}
		return null;
	}
}
