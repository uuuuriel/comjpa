package senai.comjpa.dao.jpa;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import senai.comjpa.daoe.ClienteDAO;
import senai.comjpa.pojo.Cliente;

public class ClienteJPADAO extends JPAAbstract<Cliente> implements ClienteDAO{
	
	@Override
	public String getEntityName(){
		return "Cliente";
	}

	
}