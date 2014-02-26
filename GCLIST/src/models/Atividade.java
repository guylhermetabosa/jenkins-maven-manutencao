package models;

public class Atividade {

	
	private int idusuario;
	private int codigoatividade;
	private String titulo;
	private String descricao;
	
	public Atividade(){
	}
	public Atividade(int idusuario, int codigoatividade, String titulo,
			String descricao) {
		super();
		this.idusuario = idusuario;
		this.codigoatividade = codigoatividade;
		this.titulo = titulo;
		this.descricao = descricao;
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
	
}
