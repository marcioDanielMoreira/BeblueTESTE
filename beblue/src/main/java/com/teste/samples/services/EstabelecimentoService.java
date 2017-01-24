package com.teste.samples.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.teste.samples.controller.EstabelecimentoFACADE;
import com.teste.samples.domain.EstabelecimentoPO;
import com.teste.samples.exceptions.ApplicationException;

@Service
public class EstabelecimentoService {

	public void getEstabelecimentoById(String id) throws NumberFormatException, ApplicationException {
		EstabelecimentoFACADE facade = new EstabelecimentoFACADE();

		facade.filtrarPorId(EstabelecimentoPO.class, new Long(id));
		
	}
	
	public List<EstabelecimentoPO> getAllEstabelecimento() throws ApplicationException {
		List<EstabelecimentoPO> estabelecimentos = new ArrayList<EstabelecimentoPO>();

		for (int i = 0; i < 10; i++) {
			EstabelecimentoFACADE facade = new EstabelecimentoFACADE();

			estabelecimentos = facade.filtrarTudo(EstabelecimentoPO.class);
			
		}

		return estabelecimentos;
	}
	
	public void createEstabelecimento(EstabelecimentoPO estabelecimento) throws ApplicationException {


		EstabelecimentoFACADE facade = new EstabelecimentoFACADE();
		facade.inserir(estabelecimento);
	
	}
}
