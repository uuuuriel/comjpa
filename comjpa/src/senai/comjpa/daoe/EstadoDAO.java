package senai.comjpa.daoe;

import java.sql.SQLException;

import senai.comjpa.pojo.Estado;

public interface EstadoDAO {
	public Estado buscarPorId(int id) throws SQLException;
	
}
