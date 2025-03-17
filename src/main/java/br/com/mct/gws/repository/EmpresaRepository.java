package br.com.mct.gws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mct.gws.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
