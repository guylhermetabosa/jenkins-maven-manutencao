package models;

import java.util.Date;

public class Atividade {

	
	private int idusuario;
	private int codigoatividade;
	private String titulo;
	private String descricao;
	private Date data;
	

	
	
	
	@Override
	public String toString() {
		return "Atividade [idusuario=" + idusuario + ", codigoatividade="
				+ codigoatividade + ", titulo=" + titulo + ", descricao="
				+ descricao + ", data=" + data + "]";
	}
	public Atividade() {
	}
	public Atividade(int idusuario, int codigoatividade, String titulo,
			String descricao, Date data) {
		super();
		this.idusuario = idusuario;
		this.codigoatividade = codigoatividade;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public int getCodigoatividade() {
		return codigoatividade;
	}
	public void setCodigoatividade(int codigoatividade) {
		this.codigoatividade = codigoatividade;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
