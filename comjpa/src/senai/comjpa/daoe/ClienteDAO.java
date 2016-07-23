package senai.comjpa.daoe;

import java.sql.SQLException;

import senai.comjpa.pojo.Cliente;

public interface ClienteDAO {
	public int incluir(Cliente cliente) throws SQLException;
	public Cliente buscarPorId(int id) throws SQLException;
	
}
