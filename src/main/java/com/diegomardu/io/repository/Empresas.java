package com.diegomardu.io.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.diegomardu.io.model.Empresa;

public class Empresas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;
	
	public Empresas() {
		
	}
	
	public Empresas(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Empresa porId(Long id) {
		return entityManager.find(Empresa.class, id);
	}
	 
	public List<Empresa> pesquisar(String nome){
		
		String jpql = "from Empresa where nomeFantasia like :nomeFantasia";
		
		TypedQuery<Empresa> query = entityManager.createQuery(jpql, Empresa.class);
		query.setParameter("nomeFantasia", nome + "%");
		return query.getResultList();
	}
	
	public List<Empresa> todas(){
		
		String jpql = "from Empresa";
		
		return entityManager.createQuery(jpql, Empresa.class).getResultList();
	}
	
	public Empresa salvar(Empresa empresa) {
		return entityManager.merge(empresa);
	}
	
	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		entityManager.remove(empresa);
	}

}
