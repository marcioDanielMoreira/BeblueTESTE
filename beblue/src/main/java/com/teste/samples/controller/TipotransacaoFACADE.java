package com.teste.samples.controller;

import java.util.ArrayList;

import com.teste.samples.domain.TipotransacaoPO;
import com.teste.samples.exceptions.ApplicationException;
import com.teste.samples.interfaces.Crud;
import com.teste.samples.service.TipotransacaoSERVICE;

public class TipotransacaoFACADE implements Crud<TipotransacaoPO> {

	private TipotransacaoSERVICE SERVICE;

	public TipotransacaoFACADE(){
		SERVICE = new TipotransacaoSERVICE();
	}

	public void inserir(TipotransacaoPO po) throws ApplicationException {
		SERVICE.inserir( po );
	}

	public ArrayList<TipotransacaoPO> filtrarTudo(Class clazz) throws ApplicationException {
		return SERVICE.filtrarTudo( clazz );
	}

	public TipotransacaoPO filtrarPorId(Class clazz, Long id) throws ApplicationException {
		return SERVICE.filtrarPorId( clazz, id );
	}
	
	public TipotransacaoPO filtrarPorTipo(Class clazz, String tipo) throws ApplicationException {
		return SERVICE.filtrarPorTipo( clazz, tipo );
	}

	public ArrayList<TipotransacaoPO> filtrar(TipotransacaoPO poFiltrar) throws ApplicationException {
		return SERVICE.filtrar( poFiltrar );
	}

	

}
