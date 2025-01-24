package com.diegomardu.io.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.property.access.spi.Setter;

import com.diegomardu.io.model.Empresa;
import com.diegomardu.io.model.RamoAtividade;
import com.diegomardu.io.model.TipoEmpresa;
import com.diegomardu.io.repository.Empresas;
import com.diegomardu.io.repository.RamoAtividades;
import com.diegomardu.io.service.CadastroEmpresaService;
import com.diegomardu.io.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;
	
	@Inject
	private CadastroEmpresaService  cadastroEmpresaService;
	
	@Inject
	private FacesMessages messages;
	
	@Inject
	private RamoAtividades ramoAtividades;
	
	private List<Empresa> listaEmpresas;
	
	private String termoPesquisa;
	
	private Converter converter;
	
	private Empresa empresa;
	
	public void preparaNovaEmpresa() {
		empresa = new Empresa();
	}
	
	public void salvar() {
		cadastroEmpresaService.salvar(empresa);
		
		if(jaHouvePesquisa()) {
			pesquisar();
		}
		messages.info("Empresa cadastrada com sucesso.");
		
	}
	
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
	
	public List<RamoAtividade> completarRamoAtividade(String termo){
		
		List<RamoAtividade> ramos = ramoAtividades.pesquisar(termo);
		
		converter = new RamoAtividadeConverter(ramos);
		
		return ramos;
	}
	
	private boolean jaHouvePesquisa() {
		return termoPesquisa != null && !"".equals(termoPesquisa);
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
	
	public Converter getConverter() {
		return converter;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
}
