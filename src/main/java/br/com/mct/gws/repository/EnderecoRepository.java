package br.com.mct.gws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mct.gws.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
