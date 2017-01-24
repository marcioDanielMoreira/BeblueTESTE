package com.teste.samples.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.teste.samples.controller.TransacaoFACADE;
import com.teste.samples.controller.UsuarioFACADE;
import com.teste.samples.domain.TipotransacaoPOJO;
import com.teste.samples.domain.TransacaoPO;
import com.teste.samples.domain.UsuarioPO;
import com.teste.samples.exceptions.ApplicationException;

@Service
public class TransacaoService {

	private static final Logger logger_c = Logger.getLogger(TransacaoService.class);

	public void getTransacaoById(String id) throws NumberFormatException, ApplicationException {
		TransacaoFACADE facade = new TransacaoFACADE();

		facade.filtrarPorId(TransacaoPO.class, new Long(id));

	}
	
	public void getTransacaoByCpf(String cpf) throws NumberFormatException, ApplicationException {
		TransacaoFACADE facade = new TransacaoFACADE();

		facade.filtrarPorCPF(TransacaoPO.class, cpf);

	}

	public List<TransacaoPO> getAllTransacao() throws ApplicationException {
		List<TransacaoPO> transacaoes = new ArrayList<TransacaoPO>();

		for (int i = 0; i < 10; i++) {
			TransacaoFACADE facade = new TransacaoFACADE();

			transacaoes = facade.filtrarTudo(TransacaoPO.class);

		}

		return transacaoes;
	}

	public void createTransacao(TransacaoPO transacao) throws ApplicationException {
		RestTemplate restTemplate = new RestTemplate();

		TipotransacaoPOJO[] pojos = restTemplate.getForObject(
				"https://quarkbackend.com/getfile/vilibaldo-neto/json-javatest-transactiontypr",
				TipotransacaoPOJO[].class);
		
		ArrayList<TipotransacaoPOJO> tiposTransacoes = new ArrayList<TipotransacaoPOJO>(Arrays.asList(pojos));
		String nomeTipoTransacaoSelecionado = null;
		
		for (TipotransacaoPOJO tipotransacaoCorrente : tiposTransacoes) {
			if(tipotransacaoCorrente.getTransaction_type().equals(transacao.getTransaction_type())){
				nomeTipoTransacaoSelecionado = tipotransacaoCorrente.getTransaction_name();
				break;
			}
		}
		
		TransacaoFACADE facade = new TransacaoFACADE();
		try {
			logger_c.debug("Persisting fund in database: " + transacao.toString());
			facade.inserir(transacao,nomeTipoTransacaoSelecionado);
			facade.calcularCashback(transacao, nomeTipoTransacaoSelecionado);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static UsuarioPO filtrarPorCPF(String cpf) {
		UsuarioFACADE facade = new UsuarioFACADE();
		try {
			UsuarioPO usuario = facade.filtrarPorCPF(UsuarioPO.class, cpf);
			return usuario;
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

}
