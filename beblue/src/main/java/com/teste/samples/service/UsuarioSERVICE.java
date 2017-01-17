package com.teste.samples.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.teste.samples.dao.UsuarioDAO;
import com.teste.samples.domain.UsuarioPO;
import com.teste.samples.exceptions.ApplicationException;
import com.teste.samples.interfaces.Crud;


public final class UsuarioSERVICE implements Crud<UsuarioPO> {

	
	private final UsuarioDAO DAO;

	
	public UsuarioSERVICE(){
		DAO = new UsuarioDAO();
	}	

	public void alterar( UsuarioPO po ) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			DAO.alterar( po );
			DAO.confirmarTransacao();
		} catch ( ApplicationException e ) {
			DAO.desfazerTransacao();
			throw e;
		} catch ( Exception e ) {
			DAO.desfazerTransacao();
			throw new ApplicationException( "Erro desconhecido", e );
		}

	}

	
	public void inserir(UsuarioPO po) throws ApplicationException {
		ArrayList< UsuarioPO > consulta = filtrar( po );

		if ( consulta != null ) {
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
		} else {
			throw new ApplicationException( "Usuário já existe!" );
		}
	}



	public ArrayList<UsuarioPO> filtrarTudo(Class clazz) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			ArrayList< UsuarioPO > encontrados = this.DAO.filtrarTudo( UsuarioPO.class );
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


	
	public UsuarioPO filtrarPorId(Class clazz, Long id) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			UsuarioPO encontrado = this.DAO.filtrarPorId( UsuarioPO.class, id );
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
	
	public UsuarioPO filtrarPorCPF(Class clazz, String cpf) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			UsuarioPO encontrado = this.DAO.filtrarPorCPF( UsuarioPO.class, cpf );
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



	public ArrayList<UsuarioPO> filtrar(UsuarioPO poFiltrar) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			ArrayList< UsuarioPO > encontrados = DAO.filtrar( poFiltrar );
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
