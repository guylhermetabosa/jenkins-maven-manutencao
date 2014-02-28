package dao;

import models.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{
	public Usuario salvarUser(String nome, String senha);
	public Usuario procurarUsuario(String nome);
}
