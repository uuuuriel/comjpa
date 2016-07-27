package senai.comjpa.dao.jpa;

import java.awt.List;
import java.lang.reflect.ParameterizedType;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public abstract class JPAAbstract<E, ID> extends JPAConnection implements Crud<E, ID>{
//
//
//	@SuppressWarnings("unchecked")
//	public String getEntityName(){
//			Class<? extends JPAAbstract> realClass = getClass();
//			ParameterizedType superclass = (ParameterizedType)realClass.getGenericSuperclass();
//			Class<E> classe = (Class<E>)superclass.getActualTypeArguments()[0];
//			String nomePadrao = classe.getSimpleName();
//			Entity annotation = classe.getAnnotation(Entity.class);
//			if ( annotation != null && !annotation.name().isEmpty() ) {
//				return annotation.name();
//			}
//			return nomePadrao;
//	};
//
//	protected void incluir(Object o){
//		EntityManager em = getEntityManager();
//		em.getTransaction().begin();
//		em.persist(o);
//		em.getTransaction().commit();
//		em.close();
//	}
//
//	protected E buscarPorId(int id){
//		String jpql = " select c from "+getEntityName()+" c where id "+ id;
//		Query query = (Query) super.getQuery(jpql);
//		java.util.List list = ((javax.persistence.Query) query).getResultList();
//		for(Object object : list){
//			return ((E) object);
//		}
//	
//		return null;
//	}
	
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
	
	public List listar(){
		return this.listar();
	}
	
	public List listar(String where){		
		String jpql = "SELECT E FROM "+ this.getEntityName() +" E";		
		if(where != null && !where.isEmpty()){
			jpql += " WHERE "+ where;
		}
		EntityManager em = getEntityManager();		
		TypedQuery<E> sql = em.createQuery(jpql,this.entidade);		
		List listaEntidade = (List) sql.getResultList();	
		return listaEntidade;
	}

}
