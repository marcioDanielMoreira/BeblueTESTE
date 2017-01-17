package com.teste.samples.service;

import java.util.ArrayList;

import com.teste.samples.dao.TipotransacaoDAO;
import com.teste.samples.domain.EstabelecimentoPO;
import com.teste.samples.domain.TipotransacaoPO;
import com.teste.samples.exceptions.ApplicationException;
import com.teste.samples.interfaces.Crud;

public final class TipotransacaoSERVICE implements Crud<TipotransacaoPO> {
	
	private final TipotransacaoDAO DAO;

	public TipotransacaoSERVICE(){
		DAO = new TipotransacaoDAO();
	}

	public void inserir(TipotransacaoPO po) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			DAO.inserir( po );
			DAO.confirmarTransacao();
		} catch ( ApplicationException e ) {
			DAO.desfazerTransacao();
			throw e;
		} catch ( Exception e ) {
			DAO.desfazerTransacao();
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	public ArrayList<TipotransacaoPO> filtrarTudo(Class clazz) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			ArrayList< TipotransacaoPO > encontrados = this.DAO.filtrarTudo( EstabelecimentoPO.class );
			DAO.confirmarTransacao();

			return encontrados;
		} catch ( ApplicationException e ) {
			DAO.desfazerTransacao();
			throw e;
		} catch ( Exception e ) {
			DAO.desfazerTransacao();
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	public TipotransacaoPO filtrarPorId(Class clazz, Long id) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			TipotransacaoPO encontrado = DAO.filtrarPorId( TipotransacaoPO.class, id );
			DAO.confirmarTransacao();

			return encontrado;
		} catch ( ApplicationException e ) {
			DAO.desfazerTransacao();
			throw e;
		} catch ( Exception e ) {
			DAO.desfazerTransacao();
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}
	
	public TipotransacaoPO filtrarPorTipo(Class clazz, String tipo) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			TipotransacaoPO encontrado = DAO.filtrarPorTipo( TipotransacaoPO.class, tipo );
			DAO.confirmarTransacao();

			return encontrado;
		} catch ( ApplicationException e ) {
			DAO.desfazerTransacao();
			throw e;
		} catch ( Exception e ) {
			DAO.desfazerTransacao();
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	public ArrayList<TipotransacaoPO> filtrar(TipotransacaoPO poFiltrar) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			ArrayList< TipotransacaoPO > encontrados = DAO.filtrar( poFiltrar );
			DAO.confirmarTransacao();

			return encontrados;
		} catch ( ApplicationException e ) {
			DAO.desfazerTransacao();
			throw e;
		} catch ( Exception e ) {
			DAO.desfazerTransacao();
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	

}
