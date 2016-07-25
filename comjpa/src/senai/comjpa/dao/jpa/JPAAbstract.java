package senai.comjpa.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import senai.comjpa.pojo.Cliente;

public abstract class JPAAbstract<? extends JPAConnection> {

    private AbstractItem item;

    public void setItem(AbstractItem item) {
    	this.item = item;
    }

    public AbstractItem getItem() {
    	return this.item;
    }
	public abstract String getEntityName();

	
	
	protected void incluir(Object o){
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}

}
