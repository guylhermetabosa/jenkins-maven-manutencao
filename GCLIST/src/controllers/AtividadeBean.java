package controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpSession;

import models.Atividade;
import models.Usuario;

@ManagedBean
public class AtividadeBean {
	private Atividade atividade;
	private Atividade atividadeaux;
	
	@ManagedProperty(value="#{repositorioBean}")
	private RepositorioBean repositorio;

	public AtividadeBean() {
		System.out.println("Instanciando AtividadelBean");
		this.atividade = new Atividade();
		this.atividadeaux = new Atividade();
	}
	
	public String cancel(){
		return "/atividade/lista?faces-redirect=true";
	}

	public String insere() {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		repositorio.insere(this.atividade,(Usuario) session.getAttribute("usuario"));
		System.out.println(atividade.toString());
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.setKeepMessages(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atividade inserido com sucesso.", null));
		return "/atividade/lista?faces-redirect=true";
	}
	
	public String remover(){
		
		for(int i=0;i<repositorio.atividades.size();i++){
			if(atividadeaux.getCodigoatividade() == repositorio.atividades.get(i).getCodigoatividade()){
				repositorio.atividades.remove(i);
			}
		}
		return "/atividade/lista?faces-redirect=true";
	}
	
	public String editar(){
		
		System.out.println(atividadeaux.toString());
		
		for(int i=0;i<repositorio.atividades.size();i++){
			if(atividadeaux.getTitulo().equals(repositorio.atividades.get(i).getTitulo())){
				
				System.out.println("ENTROUUUUUUUUUUUUUUUUu");
				
				repositorio.atividades.get(i).setTitulo(atividadeaux.getTitulo());
				repositorio.atividades.get(i).setDescricao(atividadeaux.getDescricao());
				repositorio.atividades.get(i).setData(atividadeaux.getData());
			}
		}
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
	public Atividade getAtividadeaux() {
		return atividadeaux;
	}
	public void setAtividadeaux(Atividade atividadeaux) {
		this.atividadeaux = atividadeaux;
	}
}
