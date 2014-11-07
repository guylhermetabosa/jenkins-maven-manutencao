package dao;

import java.util.List;

import models.Atividade;
import models.Usuario;

public interface GenericDAO<T> {
  public void save(T entity);
	public void delete(T entity);
	public T find(Object id);
	public List<T> find();
	public void beginTransaction();
	public void commit();
	public void rollback();
	public void close();
	void salvar(Atividade atividade);
	Usuario salvarUser(Usuario usuario);
	Usuario procurarUsuario(String nome);
}