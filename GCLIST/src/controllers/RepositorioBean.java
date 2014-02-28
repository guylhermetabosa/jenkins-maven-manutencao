package controllers;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import models.Atividade;
import dao.AtividadeDAO;
import dao.AtividadeJPADAO;

@ManagedBean
@SessionScoped
public class RepositorioBean {

	public RepositorioBean() {
		System.out.println("Instanciando RepositorioBean");
	}
	
	List<Atividade> atividades = new ArrayList<Atividade>();
	
	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> a) {
		this.atividades = a;
	}

	public String insere(Atividade atividade) {
		AtividadeDAO atd = new AtividadeJPADAO();
		atd.salvar(atividade);
		atividades.add(atividade);
		return "lista";
	}

}
