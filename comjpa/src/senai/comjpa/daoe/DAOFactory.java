package senai.comjpa.daoe;

import senai.comjpa.dao.jpa.CidadeJPADAO;
import senai.comjpa.dao.jpa.EstadoJPADAO;
import senai.comjpa.dao.jpa.ClienteJPADAO;

public class DAOFactory {
	
	@SuppressWarnings("rawtypes")
	public static Object getInstanceOf(Class c) {
		if ( c.equals(ClienteDAO.class) ) {
			return new ClienteJPADAO();
		} else if ( c.equals(CidadeDAO.class) ) {
			return new CidadeJPADAO();
		} else if ( c.equals(EstadoDAO.class) ) {
			return new EstadoJPADAO();
		}
		return null;
	}
}
