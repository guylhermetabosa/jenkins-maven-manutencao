package dao;

import models.Atividade;

public interface AtividadeDAO extends GenericDAO<Atividade>{
	public void salvar(Atividade atividade);
}
