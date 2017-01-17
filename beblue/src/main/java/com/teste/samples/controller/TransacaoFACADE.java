package com.teste.samples.controller;

import java.util.ArrayList;

import com.teste.samples.domain.TransacaoPO;
import com.teste.samples.domain.UsuarioPO;
import com.teste.samples.exceptions.ApplicationException;
import com.teste.samples.interfaces.Crud;
import com.teste.samples.service.TransacaoSERVICE;

public class TransacaoFACADE{

	private TransacaoSERVICE SERVICE;

	public TransacaoFACADE(){
		SERVICE = new TransacaoSERVICE();
	}

	public void inserir(TransacaoPO po,String nomeTipoTransacaoSelecionado) throws ApplicationException {
		SERVICE.inserir( po , nomeTipoTransacaoSelecionado);	
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
	
	public void calcularCashback(TransacaoPO transacao, String nomeTipoTransacao) throws ApplicationException{
		SERVICE.calcularCashback(transacao, nomeTipoTransacao);
	}

	public TransacaoPO filtrarPorCPF(Class clazz, String cpf) throws ApplicationException {
		return SERVICE.filtrarPorCPF( clazz, cpf );
	}

}
