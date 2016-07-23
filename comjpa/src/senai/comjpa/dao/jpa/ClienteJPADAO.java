package senai.comjpa.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import senai.comjpa.daoe.ClienteDAO;
import senai.comjpa.pojo.Cliente;

public class ClienteJPADAO extends JPAAbstract implements ClienteDAO{
	
	@Override
	public Cliente buscarPorId(int id){
		String jpql = " select c from Cliente c where id "+ id;
		Query query = super.getQuery(jpql);
		List list = query.getResultList();
		for(Object object : list){
			return ((Cliente) object);
		}
		
		return null;
	}
	
}