package br.com.mct.gws.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mct.gws.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
	Page<Empresa> findAll (Pageable pageable);
}
