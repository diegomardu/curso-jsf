package com.diegomardu.io.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.diegomardu.io.model.Empresa;
import com.diegomardu.io.model.TipoEmpresa;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/*
	 * private static Integer NUMERO = 0;
	 * 
	 * public GestaoEmpresasBean() { NUMERO++; }
	 * 
	 * public Integer getNumero() { return NUMERO; }
	 */
	
	private Empresa empresa = new Empresa();
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void salvar() {
		System.out.println("Razao Social: " + empresa.getRazaoSocial()
				+ " - Nome Fantasia:  " + empresa.getNomeFantasia() 
				+ " - Tipo Empresa: " + empresa.getTipoEmpresa());
	}
	
	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}
	
	public String ajuda() {
		return "AjudaGestaoEmpresas?faces-redirect=true";
	}

}
