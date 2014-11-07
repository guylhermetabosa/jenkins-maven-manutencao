package dao;

import models.Atividade;
import models.Usuario;

public class AtividadeJPADAO extends GenericJPADAO<Atividade> implements AtividadeDAO{
	public AtividadeJPADAO(){
		this.persistentClass=Atividade.class;
	}

	@Override
	public void salvar(Atividade atividade) {
		AtividadeDAO atd= new AtividadeJPADAO();
		try{
			atd.beginTransaction();
			System.out.println(atividade.toString());
			atd.save(atividade);
		}catch(Exception e){
			e.printStackTrace();
			try{
				atd.rollback();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}finally{
			//atd.close();
		}
		
	}

	public Usuario salvarUser(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}
}
