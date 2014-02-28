package dao;

import models.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{
	public Usuario salvarUser(Usuario usuario);
	public Usuario procurarUsuario(String nome);
}
