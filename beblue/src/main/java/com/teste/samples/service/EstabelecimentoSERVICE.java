package com.teste.samples.service;

import java.util.ArrayList;

import com.teste.samples.dao.EstabelecimentoDAO;
import com.teste.samples.domain.EstabelecimentoPO;
import com.teste.samples.exceptions.ApplicationException;
import com.teste.samples.interfaces.Crud;

public final class EstabelecimentoSERVICE implements Crud<EstabelecimentoPO> {

	private final EstabelecimentoDAO DAO;

	public EstabelecimentoSERVICE(){
		DAO = new EstabelecimentoDAO();
	}

	public void inserir(EstabelecimentoPO po) throws ApplicationException {
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

	public ArrayList<EstabelecimentoPO> filtrarTudo(Class clazz) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			ArrayList< EstabelecimentoPO > encontrados = this.DAO.filtrarTudo( EstabelecimentoPO.class );
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

	public EstabelecimentoPO filtrarPorId(Class clazz, Long id) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			EstabelecimentoPO encontrado = this.DAO.filtrarPorId( EstabelecimentoPO.class, id );
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

	public ArrayList<EstabelecimentoPO> filtrar(EstabelecimentoPO poFiltrar) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			ArrayList< EstabelecimentoPO > encontrados = DAO.filtrar( poFiltrar );
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
