package br.com.dtech.dao;

import br.com.dtech.model.Usuario;

public interface UsuarioDao {

	public void salvar(Usuario usuario);
	public Usuario login(String login, String senha);
}
