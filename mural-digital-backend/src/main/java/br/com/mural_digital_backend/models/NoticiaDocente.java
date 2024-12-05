package br.com.mural_digital_backend.models;

import java.util.Date;

import br.com.mural_digital_backend.controllers.TurmaDocenteController;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "NoticiaDocente")
@ToString
public class NoticiaDocente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dataInicio;
	private Date dataFinal;
	@NotNull(message = "O campo  de titulo é OBRIGATÓRIO")
	@Column(name="titulo") 
	private String titulo;
	@NotNull(message = "O campo  de mensagem é OBRIGATÓRIO")
	@Column(name="mensagem") 
	private String mensagem;
	@ManyToOne
    @JoinColumn(name = "id_turma", nullable = false)  // Cria uma chave estrangeira para a turma
    private TurmaDocente turmaDocente;
    @ManyToOne
    @JoinColumn(name = "id_servidor", nullable = false)  // Cria uma chave estrangeira para o servidor
    private LoginServidor loginServidor;
	
}	
