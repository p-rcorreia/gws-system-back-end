package br.com.mct.gws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mct.gws.dto.request.EmpresaDTORequest;
import br.com.mct.gws.dto.response.EmpresaDTOResponse;
import br.com.mct.gws.service.EmpresaService;
import br.com.mct.gws.util.ApiResponse;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController{

	@Autowired
	private EmpresaService empresaService;
	
	@PostMapping
	public ResponseEntity<Object> cadastrar(@RequestBody EmpresaDTORequest empresaDTORequest){
		
		try {
			EmpresaDTOResponse empresaDTOResponse = empresaService.cadastrar(empresaDTORequest);			
			ApiResponse<EmpresaDTOResponse> response = new ApiResponse<EmpresaDTOResponse>(
					"sucesso",
					"Empresa cadastrada com sucesso",
					empresaDTOResponse);			
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
			
		} catch (RuntimeException e) {			
			ApiResponse<Object> response = new ApiResponse<>(
					 "erro",
					 "Erro ao cadastrar empresa. Dados inválidos");			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluir(@PathVariable Long id){
		
		try {
			empresaService.excluir(id);			
			ApiResponse<Object> response = new ApiResponse<>(
					"sucesso",
					"Empresa excluída com sucesso");
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		} catch (RuntimeException e) {
			ApiResponse<Object> response = new ApiResponse<>("erro", "Empresa não encontrada");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody EmpresaDTORequest empresaDTORequest){
		
		try {
			EmpresaDTOResponse empresaDTOResponse = empresaService.atualizar(empresaDTORequest, id);
			
			ApiResponse<EmpresaDTOResponse> response = new ApiResponse<>(
					"sucesso",
					 "Empresa atualizada com sucesso",
					 empresaDTOResponse);
			
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		} catch (RuntimeException e) {
			ApiResponse<EmpresaDTOResponse> response = new ApiResponse<>(
					 "erro", 
	                    "Erro ao atualizar empresa. Dados inválidos");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	@GetMapping
	public ResponseEntity<Object> listarTodos(){
		
		try {
			List<EmpresaDTOResponse> empresas = empresaService.listarTodos();
			
			ApiResponse <List<EmpresaDTOResponse>> response = new ApiResponse<>(
					"sucesso",
					"Empresas listadas com sucesso",
					empresas);
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		} catch (RuntimeException e) {
			ApiResponse<Object> response = new ApiResponse<>(
					"erro",
					"Erro ao listar empresas");			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable Long id){		
		
		try {
			EmpresaDTOResponse empresaDTOResponse = empresaService.buscarPorId(id);
			
			ApiResponse<EmpresaDTOResponse> response = new ApiResponse<EmpresaDTOResponse>(
					"sucesso",
					"Empresa encontrada",
					empresaDTOResponse);
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		} catch (RuntimeException e) {
			ApiResponse<Object> response = new ApiResponse<>(
					"erro",
					"Empresa não encontrada");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}
}
