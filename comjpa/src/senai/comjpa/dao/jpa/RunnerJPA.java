package senai.comjpa.dao.jpa;

import senai.comjpa.pojo.Cidade;
import senai.comjpa.pojo.Cliente;
import senai.comjpa.pojo.Estado;

public class RunnerJPA {
	
	public static void main(String[] args){
		Estado sc = new Estado();
		sc.setNome("Santa Catarina");
		sc.setUf("SC");
		
		Cidade joi = new Cidade();

		joi.setEstado(sc);
		joi.setNome("Joinville");
		
		Cliente eu = new Cliente();

		eu.setCidade(joi);
		eu.setNome("Thiago");
	
		JPAAbstract jpa =  new JPAAbstract() {};
		//jpa.incluir(eu);
		System.out.println(jpa.buscarPorId(1).toString());
		
		System.out.println("Estado inserido com o id "+sc.getId()+ "  -  "+eu.getNome());
	}

}
