package br.com.mct.gws.dto.response;

import java.time.LocalDateTime;

import br.com.mct.gws.enums.TipoDominio;

public class DominioDTOResponse {
	
	  	private Long id;
	    private String dominio;
	    private TipoDominio tipo;
	    private LocalDateTime criadoEm;
	    private LocalDateTime atualizadoEm;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDominio() {
			return dominio;
		}
		public void setDominio(String dominio) {
			this.dominio = dominio;
		}
		public TipoDominio getTipo() {
			return tipo;
		}
		public void setTipo(TipoDominio tipo) {
			this.tipo = tipo;
		}
		public LocalDateTime getCriadoEm() {
			return criadoEm;
		}
		public void setCriadoEm(LocalDateTime criadoEm) {
			this.criadoEm = criadoEm;
		}
		public LocalDateTime getAtualizadoEm() {
			return atualizadoEm;
		}
		public void setAtualizadoEm(LocalDateTime atualizadoEm) {
			this.atualizadoEm = atualizadoEm;
		}
}
