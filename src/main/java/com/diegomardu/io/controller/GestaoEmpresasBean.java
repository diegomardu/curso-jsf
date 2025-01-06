package com.diegomardu.io.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.property.access.spi.Setter;

import com.diegomardu.io.model.Empresa;
import com.diegomardu.io.model.TipoEmpresa;
import com.diegomardu.io.repository.Empresas;
import com.diegomardu.io.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;
	
	@Inject
	private FacesMessages messages;
	
	private List<Empresa> listaEmpresas;
	
	private String termoPesquisa;
	
	public void pesquisar() {
		listaEmpresas = empresas.pesquisar(termoPesquisa);
		
		if(listaEmpresas.isEmpty()) {
			messages.info("Sua consulta não retornou resgistros!!");
		}
	}
	
	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}
	
	public void todasEmpresas() {
		listaEmpresas = empresas.todas();
	}
	
	public String getTermoPesquisa() {
		return termoPesquisa;
	}
	
	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
	
	public TipoEmpresa[] getTipoEmpresa() {
		return TipoEmpresa.values();
	}
	
}
