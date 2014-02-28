package controllers;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import models.Atividade;
import models.Usuario;
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

	public void insere(Atividade atividade, Usuario usuario) {
		AtividadeDAO atd = new AtividadeJPADAO();
		atividade.setUsuario(usuario);
		atd.salvar(atividade);
		System.out.println("Adicionado com sucesso");
		atividades.add(atividade);
	}
	public void remover(Atividade atividade){
		AtividadeDAO atd = new AtividadeJPADAO();
		atd.delete(atividade);
	}

}
