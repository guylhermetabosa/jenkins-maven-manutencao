package controllers;

import javax.faces.bean.ManagedBean;

import models.Usuario;

@ManagedBean
public class CadastrarBean {

	private Usuario usuario;

	
	public String cadastrar(){
		
		return "/login?faces-redirect=true";
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
