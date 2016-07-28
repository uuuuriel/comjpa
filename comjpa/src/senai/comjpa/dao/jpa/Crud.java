package senai.comjpa.dao.jpa;

import java.util.List;

public interface Crud<E, ID> {
	public E getObjeto(ID id);
	public void cadastrar(E e);
	public void editar(E e);
	public void remover(ID id);
	public List<E> listar();
	public List<E> listar(String where);

}
