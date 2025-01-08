package com.diegomardu.io.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.diegomardu.io.model.RamoAtividade;

public class RamoAtividadeConverter implements Converter {
	
	private List<RamoAtividade> listaRamoAtividade;
	
	public RamoAtividadeConverter(List<RamoAtividade> listaRamoAtividade) {
		this.listaRamoAtividade = listaRamoAtividade;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if(value == null) return null;
		
		Long id = Long.valueOf(value);
		
		for(RamoAtividade atividade: listaRamoAtividade) {
			if(id.equals(atividade.getId())) {
				return atividade;
			}
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value == null) return null;
		
		RamoAtividade ramoAtividade = (RamoAtividade) value;
		
		return ramoAtividade.getId().toString();
	}

}
