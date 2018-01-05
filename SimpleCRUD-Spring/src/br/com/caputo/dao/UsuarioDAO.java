package br.com.caputo.dao;

import java.util.List;

import br.com.caputo.entities.Usuario;

public interface UsuarioDAO {

	void delete(Usuario deleted);
	 
    List<Usuario> findAll();
 
    Usuario findById(Integer id);
 
    Usuario inserir(Usuario persisted);
}
