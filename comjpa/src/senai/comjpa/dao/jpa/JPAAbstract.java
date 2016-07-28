package senai.comjpa.dao.jpa;

import java.lang.reflect.ParameterizedType;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public abstract class JPAAbstract<E, ID> extends JPAConnection implements Crud<E, ID>{

	private Class<E> entidade;
	
	@SuppressWarnings("unchecked")
	public JPAAbstract(){
		@SuppressWarnings("rawtypes")
		Class<? extends JPAAbstract> realClass = getClass();
		ParameterizedType superclass = (ParameterizedType) realClass.getGenericSuperclass();
		this.entidade = (Class<E>) superclass.getActualTypeArguments()[0];
	}
	
	
	private String getEntityName(){		
		String nomePadrao = this.entidade.getSimpleName();		
		Entity annotation = this.entidade.getAnnotation(Entity.class);		
		if ( annotation != null && !annotation.name().isEmpty() ) {
			return annotation.name();
		}		
		return nomePadrao;
	}
	
	public E getObjeto(ID id){	
		EntityManager em = getEntityManager();
		E e = em.find(this.entidade, id);
		return e;
	}
	
	public void cadastrar(E e) {	
		EntityManager em = getEntityManager();		
		em.getTransaction().begin();	
		em.persist(e);	
		em.getTransaction().commit();	
		em.close();
	}

	public void editar(E e) {
		EntityManager em = getEntityManager();		
		em.getTransaction().begin();		
		em.merge(e);		
		em.getTransaction().commit();
		em.close();
	}

	public void remover(ID id){		
		E e = this.getObjeto(id);		
		EntityManager em = getEntityManager();		
		em.getTransaction().begin();		
		e = em.merge(e);
		em.remove(e);		
		em.getTransaction().commit();		
		em.close();
	}
	
	public java.util.List<E> listar(){
		return this.listar();
	}
	
	public java.util.List<E> listar(String where){		
		String jpql = "SELECT E FROM "+ this.getEntityName() +" E";		
		if(where != null && !where.isEmpty()){
			jpql += " WHERE "+ where;
		}
		EntityManager em = getEntityManager();		
		TypedQuery<E> sql = em.createQuery(jpql,this.entidade);		
		java.util.List<E> listaEntidade = sql.getResultList();	
		return listaEntidade;
	}

}
