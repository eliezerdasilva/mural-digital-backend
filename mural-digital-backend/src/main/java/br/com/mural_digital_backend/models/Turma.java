package br.com.mural_digital_backend.models;

public enum Turma {
	INFO301("Info-301"), INFO302("Info-302"), INFO201("Info-201"),INFO202("Info-202"),INFO101("Info-101"),INFO102("Info-102");

	private final String descricao;

	Turma(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
