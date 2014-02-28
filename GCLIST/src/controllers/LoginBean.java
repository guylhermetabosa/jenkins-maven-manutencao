package controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import models.Usuario;
import dao.UsuarioDAO;
import dao.UsuarioJPADAO;

@ManagedBean(name="loginBean")
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 9108781020220176401L;
	private String nome;
	private String senha;
	private HttpSession session;
	public LoginBean() {
		System.out.println("construtor login bean");
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}
	
	public String login() {
		session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (verificarUser(this.nome,this.senha)) {
			System.out.println("IF");
			if (session == null) {
				session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			}
			session.setAttribute("nome", nome);
			return "/index?faces-redirect=true";
		} else {
			if (session != null) {
				session.invalidate();
			}
		}
		return "/login";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean verificarUser(String nome, String senha){
		UsuarioDAO usd = new UsuarioJPADAO();
		try{
			List<Usuario> users = usd.find();
			
			for(Usuario u: users){
				System.out.println(u.getNome() + " " + u.getSenha());
				
				if(u.getNome().equals(nome) && u.getSenha().equals(senha)){
					System.out.println(nome + " " + senha);
					//session.setAttribute("usuario", u);
					return true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}

