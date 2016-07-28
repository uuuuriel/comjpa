package senai.comjpa.daoe;

import java.sql.SQLException;

import senai.comjpa.dao.jpa.Crud;
import senai.comjpa.pojo.Cidade;
import senai.comjpa.pojo.Cliente;

public interface ClienteDAO  extends Crud<Cliente,Integer>{}