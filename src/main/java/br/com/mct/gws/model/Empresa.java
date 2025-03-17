package br.com.mct.gws.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String cnpj;
	private String razaoSocial;
	
	@Column(name = "criado_em")
	@CreationTimestamp
	private LocalDateTime criadoEm;
	
	@Column(name = "atualizado_em")
	@UpdateTimestamp
	private LocalDateTime atualizadoEm;
	
	@OneToOne(mappedBy = "empresa", cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<Dominio> dominio;
	
	@ManyToMany(mappedBy = "empresas")
	private List<Contato> contato;
	
	public List<Dominio> getDominio() {
		return dominio;
	}

	public void setDominio(List<Dominio> dominio) {
		this.dominio = dominio;
	}

	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(java.util.List<Contato> contato) {
		this.contato = contato;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}
	public LocalDateTime getAtualizadoEm() {
		return atualizadoEm;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
