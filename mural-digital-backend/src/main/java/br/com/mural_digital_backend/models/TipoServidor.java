package br.com.mural_digital_backend.models;

public enum TipoServidor {
	DOCENTE("Docente"), SISAE("SISAE"), RESTAURANTE("Restaurante"), NServidor("Não-Servidor");

	private final String descricao;

	TipoServidor(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
