package br.com.mct.gws.model;

import java.time.LocalDateTime;

import br.com.mct.gws.enums.TipoDominio;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dominios")
public class Dominio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String dominio;
	
	@Enumerated(EnumType.STRING)
	private TipoDominio tipo;
	
	@Column(name = "criado_em")
    private LocalDateTime criadoEm;

    public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;
    
    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    private Empresa empresa;

	public Long getId() {
		return id;
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
	
	public LocalDateTime getAtualizadoEm() {
		return atualizadoEm;
	}
}
