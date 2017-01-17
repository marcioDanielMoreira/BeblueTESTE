package com.teste.samples.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.teste.samples.controller.EstabelecimentoFACADE;
import com.teste.samples.controller.UsuarioFACADE;
import com.teste.samples.dao.TransacaoDAO;
import com.teste.samples.domain.EstabelecimentoPO;
import com.teste.samples.domain.TransacaoPO;
import com.teste.samples.domain.UsuarioPO;
import com.teste.samples.exceptions.ApplicationException;
import com.teste.samples.interfaces.Crud;

public final class TransacaoSERVICE implements Crud<TransacaoPO> {

	private final TransacaoDAO DAO;

	public TransacaoSERVICE(){
		DAO = new TransacaoDAO();
	}

	

	public Integer diaDaSemana( Date data ) {
		Calendar cal = Calendar.getInstance();
		cal.setTime( data );
		int day = cal.get( Calendar.DAY_OF_WEEK );
		return day;
	}

	public void calcularCashback( TransacaoPO transacao ) throws ApplicationException {
		if ( transacao.getTransaction_type() == "TP_1" ) {
			Double balance = transacao.getUsuario().getBalance();
			Double balance_atualizado = balance - transacao.getValue();
			if ( !( balance_atualizado >= 0 ) ) {
				throw new ApplicationException( "Saldo Insuficiente!" );
			}
			UsuarioFACADE facade = new UsuarioFACADE();

			UsuarioPO user = facade.filtrarPorId( UsuarioPO.class, transacao.getUsuario().getId() );
			user.setBalance( balance_atualizado );
			facade.alterar( user );
		}

		int diaDaSemana = diaDaSemana( transacao.getDate() );
		if ( diaDaSemana == 1 ) {
			Double balance = transacao.getUsuario().getBalance();
			Double balance_atualizado = balance + ( transacao.getValue() * transacao.getMerchant_id().getDomingo() );

			if ( !( balance_atualizado >= 0 ) ) {
				throw new ApplicationException( "Saldo Insuficiente!" );
			}
			UsuarioFACADE facade = new UsuarioFACADE();

			UsuarioPO user = facade.filtrarPorId( UsuarioPO.class, transacao.getUsuario().getId() );
			user.setBalance( balance_atualizado );
			facade.alterar( user );
		}

		if ( diaDaSemana == 2 ) {
			Double balance = transacao.getUsuario().getBalance();
			Double balance_atualizado = balance + ( transacao.getValue() * transacao.getMerchant_id().getSegunda() );

			if ( !( balance_atualizado >= 0 ) ) {
				throw new ApplicationException( "Saldo Insuficiente!" );
			}
			UsuarioFACADE facade = new UsuarioFACADE();

			UsuarioPO user = facade.filtrarPorId( UsuarioPO.class, transacao.getUsuario().getId() );
			user.setBalance( balance_atualizado );
			facade.alterar( user );
		}

		if ( diaDaSemana == 3 ) {
			Double balance = transacao.getUsuario().getBalance();
			Double balance_atualizado = balance + ( transacao.getValue() * transacao.getMerchant_id().getTerca() );

			if ( !( balance_atualizado >= 0 ) ) {
				throw new ApplicationException( "Saldo Insuficiente!" );
			}
			UsuarioFACADE facade = new UsuarioFACADE();

			UsuarioPO user = facade.filtrarPorId( UsuarioPO.class, transacao.getUsuario().getId() );
			user.setBalance( balance_atualizado );
			facade.alterar( user );
		}

		if ( diaDaSemana == 4 ) {
			Double balance = transacao.getUsuario().getBalance();
			Double balance_atualizado = balance + ( transacao.getValue() * transacao.getMerchant_id().getQuarta() );

			if ( !( balance_atualizado >= 0 ) ) {
				throw new ApplicationException( "Saldo Insuficiente!" );
			}
			UsuarioFACADE facade = new UsuarioFACADE();

			UsuarioPO user = facade.filtrarPorId( UsuarioPO.class, transacao.getUsuario().getId() );
			user.setBalance( balance_atualizado );
			facade.alterar( user );
		}

		if ( diaDaSemana == 5 ) {
			UsuarioFACADE facade = new UsuarioFACADE();
			UsuarioPO user = facade.filtrarPorId( UsuarioPO.class, transacao.getUsuario().getId() );

			EstabelecimentoFACADE facadeE = new EstabelecimentoFACADE();
			EstabelecimentoPO estabelecimento = facadeE.filtrarPorId( EstabelecimentoPO.class, transacao.getMerchant_id().getId() );

			Double balance = user.getBalance();
			Double balance_atualizado = balance + ( transacao.getValue() * estabelecimento.getQuinta() );

			if ( !( balance_atualizado >= 0 ) ) {
				throw new ApplicationException( "Saldo Insuficiente!" );
			}

			user.setBalance( balance_atualizado );
			facade.alterar( user );
		}

		if ( diaDaSemana == 6 ) {
			UsuarioFACADE facade = new UsuarioFACADE();
			UsuarioPO user = facade.filtrarPorId( UsuarioPO.class, transacao.getUsuario().getId() );

			EstabelecimentoFACADE facadeE = new EstabelecimentoFACADE();
			EstabelecimentoPO estabelecimento = facadeE.filtrarPorId( EstabelecimentoPO.class, transacao.getMerchant_id().getId() );

			Double balance = user.getBalance();
			Double balance_atualizado = balance + ( transacao.getValue() * estabelecimento.getSexta() );

			if ( !( balance_atualizado >= 0 ) ) {
				throw new ApplicationException( "Saldo Insuficiente!" );
			}

			user.setBalance( balance_atualizado );
			facade.alterar( user );
		}

		if ( diaDaSemana == 7 ) {
			Double balance = transacao.getUsuario().getBalance();
			Double balance_atualizado = balance + ( transacao.getValue() * transacao.getMerchant_id().getSabado() );

			if ( !( balance_atualizado >= 0 ) ) {
				throw new ApplicationException( "Saldo Insuficiente!" );
			}
			UsuarioFACADE facade = new UsuarioFACADE();

			UsuarioPO user = facade.filtrarPorId( UsuarioPO.class, transacao.getUsuario().getId() );
			user.setBalance( balance_atualizado );
			facade.alterar( user );
		}
	}



	public void inserir(TransacaoPO po) throws ApplicationException {
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



	public ArrayList<TransacaoPO> filtrarTudo(Class clazz) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			ArrayList< TransacaoPO > encontrados = DAO.filtrarTudo( TransacaoPO.class );
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



	public TransacaoPO filtrarPorId(Class clazz, Long id) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			TransacaoPO encontrado = DAO.filtrarPorId( TransacaoPO.class, id );
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



	public ArrayList<TransacaoPO> filtrar(TransacaoPO poFiltrar) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			ArrayList< TransacaoPO > encontrados = DAO.filtrar( poFiltrar );
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
