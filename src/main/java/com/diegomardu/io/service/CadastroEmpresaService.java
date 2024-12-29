package com.diegomardu.io.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.diegomardu.io.model.Empresa;
import com.diegomardu.io.repository.Empresas;
import com.diegomardu.io.util.Transacional;

public class CadastroEmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;
	
	@Transacional
	public void salvar(Empresa empresa) {
		empresas.salvar(empresa);
	}
	
	@Transacional 
	public void excluir(Empresa empresa) {
		empresas.remover(empresa);
	}

}
