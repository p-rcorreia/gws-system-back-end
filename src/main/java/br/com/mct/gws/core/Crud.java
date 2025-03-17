package br.com.mct.gws.core;

import java.util.List;

public interface Crud<T, J, ID> {

	T cadastrar(J entity);
	void excluir(ID id);
	T atualizar(J entity, ID id);
	List<T> listarTodos();
}
