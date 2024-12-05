package br.com.mural_digital_backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Entity
@ToString
public class TurmaDocente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING) 
	@Column(nullable = false)
	private Turma turma;	
	@NotNull(message = "O campo  de disciplina é OBRIGATÓRIO")
	@Column(name="disciplina") 
	private String disciplina;
	@NotNull(message = "O campo  de loginServidor é OBRIGATÓRIO")
	@ManyToOne
    @JoinColumn(name = "id_servidor", referencedColumnName = "idServidor", nullable = false)
    private LoginServidor loginServidor;
	
    
}
