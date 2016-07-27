package senai.comjpa.dao.jpa;

import java.awt.List;
import java.lang.reflect.ParameterizedType;

import javax.management.Query;
import javax.persistence.Entity;
import javax.persistence.EntityManager;

import senai.comjpa.pojo.Estado;

public abstract class JPAAbstract<E> extends JPAConnection{


	@SuppressWarnings("rawtypes")
	public String getEntityName(){
			Class<? extends JPAAbstract> realClass = getClass();
			ParameterizedType superclass = (ParameterizedType)realClass.getGenericSuperclass();
			Class<E> classe = (Class<E>)superclass.getActualTypeArguments()[0];
			String nomePadrao = classe.getSimpleName();
			Entity annotation = classe.getAnnotation(Entity.class);
			if ( annotation != null && !annotation.name().isEmpty() ) {
				return annotation.name();
			}
			return nomePadrao;
	};

	protected void incluir(Object o){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}

//	protected buscarPorId(int id){
//		String jpql = " select c from "+getEntityName()+" c where id "+ id;
//		Query query = super.getQuery(jpql);
//		List list = query.getResultList();
//		for(Object object : list){
//			return ((Estado) object);
//		}
//		
//		return null;
//	}

}
