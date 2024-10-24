package br.com.mural_digital_backend.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.mural_digital_backend.molds.ArrayListToStringConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Cardapio")
@ToString
public class Cardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "O campo  de Carne é OBRIGATÓRIO")
	@Convert(converter = ArrayListToStringConverter.class)
	@Column(name="carnes") 
	private List<String> carnes;
	@NotNull(message = "O campo  de Opcoes Veganas é OBRIGATÓRIO")
	@Column(name="opcoes_vegana") 
	@Convert(converter = ArrayListToStringConverter.class)
	private List<String> opcoes_vegana;
	@Column(name="sucos") 
	@Convert(converter = ArrayListToStringConverter.class)
	private List<String> sucos;
	@NotNull(message = "O campo  de Saladas é OBRIGATÓRIO")
	@Convert(converter = ArrayListToStringConverter.class)
	@Column(name="saladas") 
	private List<String> saladas; 
	@NotNull(message = "O campo  de Carboidratos é OBRIGATÓRIO")
	@Convert(converter = ArrayListToStringConverter.class)
	@Column(name="carboidratos") 
	private List<String> carboidratos;
	@NotNull(message = "O campo  de Sobremesa é OBRIGATÓRIO")
	@Convert(converter = ArrayListToStringConverter.class)
	@Column(name="sobremesa") 
	private List<String> sobremesa;
	private Date data;

}
