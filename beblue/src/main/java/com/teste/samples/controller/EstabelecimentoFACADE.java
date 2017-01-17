package com.teste.samples.controller;

import java.util.ArrayList;

import com.teste.samples.domain.EstabelecimentoPO;
import com.teste.samples.exceptions.ApplicationException;
import com.teste.samples.interfaces.Crud;
import com.teste.samples.service.EstabelecimentoSERVICE;

public final class EstabelecimentoFACADE implements Crud<EstabelecimentoPO> {

	private EstabelecimentoSERVICE SERVICE;

	public EstabelecimentoFACADE(){
		SERVICE = new EstabelecimentoSERVICE();
	}

	public void inserir(EstabelecimentoPO po) throws ApplicationException {
		SERVICE.inserir( po );
	}

	public ArrayList<EstabelecimentoPO> filtrarTudo(Class clazz) throws ApplicationException {
		return SERVICE.filtrarTudo( clazz );
	}

	public EstabelecimentoPO filtrarPorId(Class clazz, Long id) throws ApplicationException {
		return SERVICE.filtrarPorId( clazz, id );
	}

	public ArrayList<EstabelecimentoPO> filtrar(EstabelecimentoPO poFiltrar) throws ApplicationException {
		return SERVICE.filtrar( poFiltrar );
	}

	
	
}
