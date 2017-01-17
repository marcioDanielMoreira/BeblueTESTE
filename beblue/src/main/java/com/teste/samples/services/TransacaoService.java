package com.teste.samples.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.teste.samples.controller.TipotransacaoFACADE;
import com.teste.samples.controller.TransacaoFACADE;
import com.teste.samples.controller.UsuarioFACADE;
import com.teste.samples.domain.TipotransacaoPO;
import com.teste.samples.domain.TransacaoPO;
import com.teste.samples.domain.UsuarioPO;
import com.teste.samples.exceptions.ApplicationException;
import com.teste.samples.service.TransacaoSERVICE;
import com.teste.samples.utilidades.Utilidades;

@Service
public class TransacaoService {

	private static final Logger logger_c = Logger.getLogger(TransacaoService.class);

	public void getFundById(String id) throws NumberFormatException, ApplicationException {
		TransacaoFACADE facade = new TransacaoFACADE();

		facade.filtrarPorId(TransacaoPO.class, new Long(id));
		
	}
	
	public List<TransacaoPO> getAllFunds() throws ApplicationException {
		List<TransacaoPO> transacaoes = new ArrayList<TransacaoPO>();

		for (int i = 0; i < 10; i++) {
			TransacaoFACADE facade = new TransacaoFACADE();

			transacaoes = facade.filtrarTudo(TransacaoPO.class);
			
		}

		return transacaoes;
	}
	
	public void createFund(TransacaoPO transacao) throws ApplicationException {
		TransacaoFACADE facade = new TransacaoFACADE();
		TransacaoSERVICE service = new TransacaoSERVICE();
		logger_c.debug("Persisting fund in database: " + transacao.toString());
		
		transacao.setDate(new Date());
		transacao.setCode(Utilidades.generateCodigoGrande());
		
		
        try {
			facade.inserir( transacao );
			service.calcularCashback( transacao );
		} catch ( ApplicationException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static UsuarioPO filtrarPorCPF( String cpf ) {
		UsuarioFACADE facade = new UsuarioFACADE();
		try {
			UsuarioPO usuario = facade.filtrarPorCPF( UsuarioPO.class, cpf );
			return usuario;
		} catch ( ApplicationException e ) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static TipotransacaoPO filtrarPorTipo( String tipo ) {
		TipotransacaoFACADE facade = new TipotransacaoFACADE();
		try {
			TipotransacaoPO transacao = facade.filtrarPorTipo( TipotransacaoPO.class, tipo );
			return transacao;
		} catch ( ApplicationException e ) {
			e.printStackTrace();
		}
		return null;
	}
}
