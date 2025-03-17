package br.com.mct.gws.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mct.gws.core.Crud;
import br.com.mct.gws.dto.request.EmpresaDTORequest;
import br.com.mct.gws.dto.response.EmpresaDTOResponse;
import br.com.mct.gws.model.Empresa;
import br.com.mct.gws.repository.EmpresaRepository;

@Service
public class EmpresaService implements Crud<EmpresaDTOResponse, EmpresaDTORequest, Long>{

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public EmpresaDTOResponse cadastrar(EmpresaDTORequest empresaDtoRequest) {		
		Empresa empresa = modelMapper.map(empresaDtoRequest, Empresa.class);		
		empresa = empresaRepository.save(empresa);		
		
		return modelMapper.map(empresa, EmpresaDTOResponse.class);	
	}
	
	@Override
	public void excluir(Long id) {
		Empresa empresa = empresaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
		empresaRepository.delete(empresa);
	}
	
	@Override
	public EmpresaDTOResponse atualizar(EmpresaDTORequest empresaDTORequest, Long id) {
		Empresa empresa = empresaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
		
		empresa.setCnpj(empresaDTORequest.getCnpj());
		empresa.setNome(empresaDTORequest.getNome());
		empresa.setRazaoSocial(empresaDTORequest.getRazaoSocial());
		
		empresa = empresaRepository.save(empresa);
		
		return modelMapper.map(empresa, EmpresaDTOResponse.class);
	}
	
	@Override
	public List<EmpresaDTOResponse> listarTodos(){
		List<Empresa> empresas = empresaRepository.findAll();
		List<EmpresaDTOResponse> empresasDtoResponse = new ArrayList<>();
		 
		for(Empresa empresa : empresas) {
			EmpresaDTOResponse empresaDtoResponse =  modelMapper.map(empresa, EmpresaDTOResponse.class);
			empresasDtoResponse.add(empresaDtoResponse);
		}
		return empresasDtoResponse;
	}
	
	public EmpresaDTOResponse buscarPorId(Long id) {
		Empresa empresa = empresaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
		
		return modelMapper.map(empresa, EmpresaDTOResponse.class);
	}
}
