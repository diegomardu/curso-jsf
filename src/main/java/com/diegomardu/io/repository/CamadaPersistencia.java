package com.diegomardu.io.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.diegomardu.io.model.Empresa;
import com.diegomardu.io.model.RamoAtividade;
import com.diegomardu.io.model.TipoEmpresa;

public class CamadaPersistencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		RamoAtividades ramoAtividades = new RamoAtividades(em);
		Empresas empresas = new Empresas(em);
		
		List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisar("");
		List<Empresa> listaEmpresas = empresas.pesquisar("");
		System.out.println(listaEmpresas);
		
		Empresa empresa = new Empresa();
		empresa.setNomeFantasia("João da Silva");
		empresa.setCnpj("41.952.519/0001-57");
		empresa.setRazaoSocial("João da Silva 41952519000157");
		empresa.setTipoEmpresa(TipoEmpresa.MEI);
		empresa.setDataFundacao(new Date());
		empresa.setRamoAtividade(listaRamoAtividades.get(0));
		
		empresas.salvar(empresa);
		em.getTransaction().commit();
		
		List<Empresa> listaDeEmpresas = empresas.pesquisar("");
		System.out.println(listaDeEmpresas);
		
		em.close();
		emf.close();		

	}

}
