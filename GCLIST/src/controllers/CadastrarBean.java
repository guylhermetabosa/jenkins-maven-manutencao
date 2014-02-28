package controllers;

import javax.faces.bean.ManagedBean;

import models.Usuario;
import dao.UsuarioDAO;
import dao.UsuarioJPADAO;

@ManagedBean
public class CadastrarBean {

	private String nome;
	private String senha;
	
	public CadastrarBean(){
		System.out.println("cadastraar bean executando");
	}
	
	public String novo(){
		UsuarioDAO usd = new UsuarioJPADAO();
		Usuario aux = usd.salvarUser(new Usuario(nome, senha));
		System.out.println(aux.toString());
		return "/login?faces-redirect=true";
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
}
