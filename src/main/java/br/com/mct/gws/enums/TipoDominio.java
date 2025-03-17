package br.com.mct.gws.enums;

public enum TipoDominio {
	
	PRIMARIO("Primário"), 
	SECUNDARIO("Secundário"),
	SUBDOMINIO("Subdomínio");
	
	private final String descricao;

	private TipoDominio(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
