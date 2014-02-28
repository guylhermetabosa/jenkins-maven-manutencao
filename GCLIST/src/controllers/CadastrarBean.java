package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import models.Usuario;
import dao.UsuarioDAO;
import dao.UsuarioJPADAO;

@ManagedBean
public class CadastrarBean {

	private Usuario usuario;
	
	public CadastrarBean(){
		System.out.println("cadastraar bean executando");
	}
	
	public String novo(){
		System.out.println(usuario.toString());
		UsuarioDAO usd = new UsuarioJPADAO();
		Usuario aux = usd.salvarUser(usuario);
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("nome", aux.getNome());
		session.setAttribute("id", aux.getId());
		System.out.println(aux.toString());
		return "/login?faces-redirect=true";
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
