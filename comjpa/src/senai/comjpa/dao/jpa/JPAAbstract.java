package senai.comjpa.dao.jpa;

import javax.persistence.EntityManager;

public abstract class JPAAbstract extends JPAConnection{
	
	
	
	protected void incluir(Object o){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}

}
