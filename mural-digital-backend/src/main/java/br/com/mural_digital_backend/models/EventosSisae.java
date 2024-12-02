package br.com.mural_digital_backend.models;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import br.com.mural_digital_backend.molds.ArrayListToStringConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Entity(name = "EventoSisae")
@ToString
public class EventosSisae {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "O campo  de titulo é OBRIGATÓRIO")
	@Column(name="titulo") 
	private String titulo;
	@NotNull(message = "O campo  de mensagem é OBRIGATÓRIO")
	@Column(name="mensagem") 
	private String mensagem;
	@NotNull(message = "O campo  de imagem é OBRIGATÓRIO")
	@Column(name="imagem") 
	@Lob
	private byte[] imagem;

}
