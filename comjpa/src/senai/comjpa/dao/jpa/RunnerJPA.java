package senai.comjpa.dao.jpa;

import senai.comjpa.daoe.ClienteDAO;
import senai.comjpa.pojo.Cidade;
import senai.comjpa.pojo.Cliente;
import senai.comjpa.pojo.Estado;

public class RunnerJPA {
	
	public static void main(String[] args){
		Estado sc = new Estado();
		sc.setNome("Santa ae");
		sc.setUf("SC");
		Cidade joi = new Cidade();
		joi.setEstado(sc);
		joi.setNome("aeffff");
		Cliente eu = new Cliente();
		eu.setCidade(joi);
		eu.setNome("faeaeaeaefffff");
		ClienteDAO jpa = new ClienteJPADAO();
		jpa.cadastrar(eu);
		//jpa.remover(2);
		//java.util.List<Cliente> ae = null;
		//System.out.println(jpa.listar());
		//jpa.editar(eu);

		System.out.println("Estado inserido com o id "+sc.getId()+ "  -  "+eu.getNome());
	}

}
