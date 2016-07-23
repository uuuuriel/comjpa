package senai.comjpa.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import senai.comjpa.daoe.EstadoDAO;
import senai.comjpa.pojo.Estado;

public class EstadoJPADAO extends JPAConnection implements EstadoDAO {

	
	@Override
	public Estado buscarPorId(int id){
		String jpql = " select c from Cliente c where id "+ id;
		Query query = super.getQuery(jpql);
		List list = query.getResultList();
		for(Object object : list){
			return ((Estado) object);
		}
		
		return null;
	}
	
	
	
}
