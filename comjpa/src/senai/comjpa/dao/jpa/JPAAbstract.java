package senai.comjpa.dao.jpa;

import javax.persistence.EntityManager;

public abstract class JPAAbstract<Object> extends JPAConnection {

	public abstract String getEntityName();

	protected void incluir(Object o){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}

//	public Object buscarPorId(int id){
//		String jpql = " select c from"+getEntityName()+" c where id "+ id;
//		Query query = super.getQuery(jpql);
//		List list = query.getResultList();
//		for(Object object : list){
//			return ((Object) object);
//		}
//		return null;
//	}

}
