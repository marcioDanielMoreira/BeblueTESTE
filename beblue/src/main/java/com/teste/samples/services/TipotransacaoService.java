package com.teste.samples.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.teste.samples.controller.TipotransacaoFACADE;
import com.teste.samples.controller.TipotransacaoFACADE;
import com.teste.samples.domain.TipotransacaoPO;
import com.teste.samples.domain.TipotransacaoPO;
import com.teste.samples.exceptions.ApplicationException;

@Service
public class TipotransacaoService {

	public void getFundById(String id) throws NumberFormatException, ApplicationException {
		TipotransacaoFACADE facade = new TipotransacaoFACADE();

		facade.filtrarPorId(TipotransacaoPO.class, new Long(id));
		
	}
	
	public List<TipotransacaoPO> getAllFunds() throws ApplicationException {
		List<TipotransacaoPO> tipos = new ArrayList<TipotransacaoPO>();

		for (int i = 0; i < 10; i++) {
			TipotransacaoFACADE facade = new TipotransacaoFACADE();

			tipos = facade.filtrarTudo(TipotransacaoPO.class);
			
		}

		return tipos;
	}
	
	public void createFund(TipotransacaoPO tipo) throws ApplicationException {


		TipotransacaoFACADE facade = new TipotransacaoFACADE();
		facade.inserir(tipo);
	
	}
}
