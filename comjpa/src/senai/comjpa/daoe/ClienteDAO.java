package senai.comjpa.daoe;

import java.sql.SQLException;

import senai.comjpa.pojo.Cliente;

public interface ClienteDAO {
	public Cliente buscarPorId(int id) throws SQLException;
	
}
