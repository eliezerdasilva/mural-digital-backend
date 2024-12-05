package br.com.mural_digital_backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Entity(name = "LoginServidor")
@ToString
public class LoginServidor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idServidor;
	@NotNull(message = "O campo  de email é OBRIGATÓRIO")
	@Column(name = "email")
	private String email;
	@NotNull(message = "O campo  de name é OBRIGATÓRIO")
	@Column(name = "name")
	private String name;
	@Enumerated(EnumType.STRING) 
	@Column(nullable = false)
	private TipoServidor tipoServidor;
}
