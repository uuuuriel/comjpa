package senai.comjpa.dao.jpa;

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
		joi.setNome("ae");
		
		Cliente eu = new Cliente();

		eu.setCidade(joi);
		eu.setNome("ae");
	
		JPAAbstract<Object, Object> jpa =  new JPAAbstract<Object, Object>() {};
		//jpa.cadastrar(eu);
		jpa.remover(4);
		
		System.out.println("Estado inserido com o id "+sc.getId()+ "  -  "+eu.getNome());
	}

}
