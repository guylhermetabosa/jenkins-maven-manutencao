package controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import models.Atividade;

@ManagedBean
public class AtividadeBean {
	private Atividade atividade;
	
	@ManagedProperty(value="#{repositorioBean}")
	private RepositorioBean repositorio;

	public AtividadeBean() {
		System.out.println("Instanciando AtividadelBean");
		this.atividade = new Atividade();
	}

	public String insere() {
		repositorio.getAtividades().add(this.atividade);
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.setKeepMessages(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atividade inserido com sucesso.", null));
		return "/atividade/lista?faces-redirect=true";
	}
	
	public RepositorioBean getRepositorio() {
		return repositorio;
	}
	public void setRepositorio(RepositorioBean repositorio) {
		this.repositorio = repositorio;
	}
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
}
