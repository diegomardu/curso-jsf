package com.diegomardu.io.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.diegomardu.io.model.Empresa;
import com.diegomardu.io.repository.Empresas;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;
	
	private List<Empresa> listaEmpresas;
	
	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}
	
	public void todasEmpresas() {
		listaEmpresas = empresas.todas();
	}
	
}
