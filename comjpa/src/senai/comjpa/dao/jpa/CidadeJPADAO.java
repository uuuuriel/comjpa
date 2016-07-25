package senai.comjpa.dao.jpa;

import senai.comjpa.daoe.CidadeDAO;
import senai.comjpa.pojo.Cidade;

public class CidadeJPADAO extends JPAAbstract<Cidade> implements CidadeDAO {

	@Override
	public String getEntityName() {
		// TODO Auto-generated method stub
		return null;
	}
/*	
	@Override
	public Cidade buscarPorId(int id){
		String jpql = " select c from Cliente c where id "+ id;
		Query query = super.getQuery(jpql);
		List list = query.getResultList();
		for(Object object : list){
			return ((Cidade) object);
		}
		
		return null;
	}*/
	
	
	
}
