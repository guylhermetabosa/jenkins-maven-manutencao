package dao;

import java.util.List;

import models.Usuario;

public class UsuarioJPADAO extends GenericJPADAO<Usuario> implements UsuarioDAO{
	public UsuarioJPADAO(){
		this.persistentClass=Usuario.class;
	}

	@Override
	public Usuario salvarUser(Usuario usuario) {
		UsuarioDAO usd = new UsuarioJPADAO();
		try{
			usd.beginTransaction();
			usd.save(usuario);
			usuario = procurarUsuario(usuario.getNome());
			System.out.println("Entrou no salvar usuario");
		}catch(Exception e){
			usd.rollback();
			e.printStackTrace();
		}finally{
			usd.close();
		}
		return usuario;
	}

	@Override
	public Usuario procurarUsuario(String nome) {
		UsuarioDAO usd = new UsuarioJPADAO();
		//usd.beginTransaction();
		List<Usuario> usuarios = usd.find();
		for(Usuario u : usuarios){
			if(u.getNome().equals(nome)){
				return u;
			}
		}
		return null;
	}
}
