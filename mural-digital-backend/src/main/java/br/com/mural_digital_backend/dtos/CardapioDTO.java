package br.com.mural_digital_backend.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class CardapioDTO {
	
	
	private Long id;
	private List<String> carnes;
	private List<String> opcoes_vegana;
	private List<String> sucos;
	private List<String> saladas; 
	private List<String> carboidratos;
	private  List<String> sobremesa;
	private Date data;

}
