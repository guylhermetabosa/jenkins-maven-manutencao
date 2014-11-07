package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Atividade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigoatividade;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="data")
	private String data;
	
	
	
	@Override
	public String toString() {
		return "Atividade [idusuario=" + usuario + ", codigoatividade="
				+ codigoatividade + ", titulo=" + titulo + ", descricao="
				+ descricao + ", data=" + data + "]";
	}
	public Atividade() {
	}
	public Atividade(Usuario usuario, int codigoatividade, String titulo,
			String descricao, String data) {
		super();
		this.usuario = usuario;
		this.codigoatividade = codigoatividade;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
