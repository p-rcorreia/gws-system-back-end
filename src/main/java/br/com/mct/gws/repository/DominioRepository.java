package br.com.mct.gws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mct.gws.model.Dominio;

public interface DominioRepository extends JpaRepository<Dominio, Long> {
}
