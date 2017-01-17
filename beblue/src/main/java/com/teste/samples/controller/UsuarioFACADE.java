package com.teste.samples.controller;

import java.util.ArrayList;

import com.teste.samples.domain.UsuarioPO;
import com.teste.samples.exceptions.ApplicationException;
import com.teste.samples.interfaces.Crud;
import com.teste.samples.service.UsuarioSERVICE;

public class UsuarioFACADE implements Crud<UsuarioPO> {

	private UsuarioSERVICE SERVICE;

	public UsuarioFACADE(){
		SERVICE = new UsuarioSERVICE();
	}

	public void inserir(UsuarioPO po) throws ApplicationException {
		SERVICE.inserir( po );
		
	}
	
	public void alterar( UsuarioPO po ) throws ApplicationException {
		SERVICE.alterar( po );
	}

	public ArrayList<UsuarioPO> filtrarTudo(Class clazz) throws ApplicationException {
		return SERVICE.filtrarTudo( clazz );
	}

	public UsuarioPO filtrarPorId(Class clazz, Long id) throws ApplicationException {
		return SERVICE.filtrarPorId( clazz, id );
	}
	
	public UsuarioPO filtrarPorCPF(Class clazz, String cpf) throws ApplicationException {
		return SERVICE.filtrarPorCPF( clazz, cpf );
	}

	public ArrayList<UsuarioPO> filtrar(UsuarioPO poFiltrar) throws ApplicationException {
		return SERVICE.filtrar( poFiltrar );
	}

	
	
}
