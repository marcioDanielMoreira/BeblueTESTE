package com.teste.samples.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.teste.samples.controller.EstabelecimentoFACADE;
import com.teste.samples.controller.UsuarioFACADE;
import com.teste.samples.dao.TransacaoDAO;
import com.teste.samples.domain.EstabelecimentoPO;
import com.teste.samples.domain.TipotransacaoPOJO;
import com.teste.samples.domain.TransacaoPO;
import com.teste.samples.domain.UsuarioPO;
import com.teste.samples.exceptions.ApplicationException;
import com.teste.samples.interfaces.Crud;
import com.teste.samples.utilidades.Utilidades;

public final class TransacaoSERVICE {

	private final TransacaoDAO DAO;

	public TransacaoSERVICE() {
		DAO = new TransacaoDAO();
	}

	public Integer diaDaSemana(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		return day;
	}

	public void calcularCashback(TransacaoPO transacao, String nomeTipoTransacao) throws ApplicationException {

		UsuarioFACADE facade = new UsuarioFACADE();
		UsuarioPO user = facade.filtrarPorCPF(UsuarioPO.class, transacao.getUser_cpf());
		EstabelecimentoFACADE estabelecimentoFacade = new EstabelecimentoFACADE();
		EstabelecimentoPO estabelecimento = estabelecimentoFacade.filtrarPorId(EstabelecimentoPO.class,
				transacao.getMerchant_id());

		if (nomeTipoTransacao.equals(TipotransacaoPOJO.CASHBACK)) {
			Double balance = user.getBalance();
			Double balance_atualizado = balance - transacao.getTransaction_value();
			if (!(balance_atualizado >= 0)) {
				throw new ApplicationException("Saldo Insuficiente!");
			}
			user.setBalance(balance_atualizado);
			facade.alterar(user);
		}

		int diaDaSemana = diaDaSemana(transacao.getDate());
		if (diaDaSemana == 1) {
			Double balance = user.getBalance();
			Double balance_atualizado = balance
					+ (transacao.getTransaction_value() * estabelecimento.getDomingo());

			if (!(balance_atualizado >= 0)) {
				throw new ApplicationException("Saldo Insuficiente!");
			}
			
			user.setBalance(balance_atualizado);
			facade.alterar(user);
		}

		if (diaDaSemana == 2) {
			Double balance = user.getBalance();
			Double balance_atualizado = balance
					+ (transacao.getTransaction_value() * estabelecimento.getSegunda());

			if (!(balance_atualizado >= 0)) {
				throw new ApplicationException("Saldo Insuficiente!");
			}
			
			user.setBalance(balance_atualizado);
			facade.alterar(user);
		}

		if (diaDaSemana == 3) {
			Double balance = user.getBalance();
			Double balance_atualizado = balance
					+ (transacao.getTransaction_value() * estabelecimento.getTerca());

			if (!(balance_atualizado >= 0)) {
				throw new ApplicationException("Saldo Insuficiente!");
			}
			
			user.setBalance(balance_atualizado);
			facade.alterar(user);
		}

		if (diaDaSemana == 4) {
			Double balance = user.getBalance();
			Double balance_atualizado = balance
					+ (transacao.getTransaction_value() * estabelecimento.getQuarta());

			if (!(balance_atualizado >= 0)) {
				throw new ApplicationException("Saldo Insuficiente!");
			}
			
			user.setBalance(balance_atualizado);
			facade.alterar(user);
		}

		if (diaDaSemana == 5) {
			Double balance = user.getBalance();
			Double balance_atualizado = balance
					+ (transacao.getTransaction_value() * estabelecimento.getQuinta());

			if (!(balance_atualizado >= 0)) {
				throw new ApplicationException("Saldo Insuficiente!");
			}
			
			user.setBalance(balance_atualizado);
			facade.alterar(user);
		}

		if (diaDaSemana == 6) {
			Double balance = user.getBalance();
			Double balance_atualizado = balance
					+ (transacao.getTransaction_value() * estabelecimento.getSexta());

			if (!(balance_atualizado >= 0)) {
				throw new ApplicationException("Saldo Insuficiente!");
			}
			
			user.setBalance(balance_atualizado);
			facade.alterar(user);
		}

		if (diaDaSemana == 7) {
			Double balance = user.getBalance();
			Double balance_atualizado = balance
					+ (transacao.getTransaction_value() * estabelecimento.getSabado());

			if (!(balance_atualizado >= 0)) {
				throw new ApplicationException("Saldo Insuficiente!");
			}
			
			user.setBalance(balance_atualizado);
			facade.alterar(user);
		}
	}

	public void inserir(TransacaoPO po, String nomeTipoTransacaoSelecionado) throws ApplicationException {
		try {
			po.setDate(new Date());
			po.setCode(Utilidades.generateCodigoGrande());
			DAO.iniciarTransacao();
			DAO.inserir(po);
			DAO.confirmarTransacao();
		} catch (ApplicationException e) {
			DAO.desfazerTransacao();
			throw e;
		} catch (Exception e) {
			DAO.desfazerTransacao();
			throw new ApplicationException("Erro desconhecido", e);
		}
	}

	public ArrayList<TransacaoPO> filtrarTudo(Class clazz) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			ArrayList<TransacaoPO> encontrados = DAO.filtrarTudo(TransacaoPO.class);
			DAO.confirmarTransacao();

			return encontrados;
		} catch (ApplicationException e) {
			DAO.desfazerTransacao();
			throw e;
		} catch (Exception e) {
			DAO.desfazerTransacao();
			throw new ApplicationException("Erro desconhecido", e);
		}
	}

	public TransacaoPO filtrarPorId(Class clazz, Long id) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			TransacaoPO encontrado = DAO.filtrarPorId(TransacaoPO.class, id);
			DAO.confirmarTransacao();

			return encontrado;
		} catch (ApplicationException e) {
			DAO.desfazerTransacao();
			throw e;
		} catch (Exception e) {
			DAO.desfazerTransacao();
			throw new ApplicationException("Erro desconhecido", e);
		}
	}

	public ArrayList<TransacaoPO> filtrar(TransacaoPO poFiltrar) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			ArrayList<TransacaoPO> encontrados = DAO.filtrar(poFiltrar);
			DAO.confirmarTransacao();

			return encontrados;
		} catch (ApplicationException e) {
			DAO.desfazerTransacao();
			throw e;
		} catch (Exception e) {
			DAO.desfazerTransacao();
			throw new ApplicationException("Erro desconhecido", e);
		}
	}
	
	public TransacaoPO filtrarPorCPF(Class clazz, String cpf) throws ApplicationException {
		try {
			DAO.iniciarTransacao();
			TransacaoPO encontrado = this.DAO.filtrarPorCPF( TransacaoPO.class, cpf );
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

}
