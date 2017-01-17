package com.teste.samples.controller;

import java.util.ArrayList;

import com.teste.samples.domain.TransacaoPO;
import com.teste.samples.exceptions.ApplicationException;
import com.teste.samples.interfaces.Crud;
import com.teste.samples.service.TransacaoSERVICE;

public class TransacaoFACADE implements Crud<TransacaoPO>{

	private TransacaoSERVICE SERVICE;

	public TransacaoFACADE(){
		SERVICE = new TransacaoSERVICE();
	}

	public void inserir(TransacaoPO po) throws ApplicationException {
		SERVICE.inserir( po );	
	}

	public ArrayList<TransacaoPO> filtrarTudo(Class clazz) throws ApplicationException {
		return SERVICE.filtrarTudo( clazz );
	}

	public TransacaoPO filtrarPorId(Class clazz, Long id) throws ApplicationException {
		return SERVICE.filtrarPorId( clazz, id );
	}

	public ArrayList<TransacaoPO> filtrar(TransacaoPO poFiltrar) throws ApplicationException {
		return SERVICE.filtrar( poFiltrar );
	}

	

}
