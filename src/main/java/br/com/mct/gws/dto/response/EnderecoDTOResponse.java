package br.com.mct.gws.dto.response;

import java.time.LocalDateTime;

public class EnderecoDTOResponse {

		private Long id;
	    private String endereco;
	    private String cidade;
	    private String estado;
	    private String pais;
	    private LocalDateTime criadoEm;
	    private LocalDateTime atualizadoEm;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		public String getCidade() {
			return cidade;
		}
		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public String getPais() {
			return pais;
		}
		public void setPais(String pais) {
			this.pais = pais;
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
