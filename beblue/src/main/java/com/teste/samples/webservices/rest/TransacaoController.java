package com.teste.samples.webservices.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.teste.samples.domain.TransacaoPO;
import com.teste.samples.domain.UsuarioPO;
import com.teste.samples.services.TransacaoService;

@Controller
public class TransacaoController {

	@Autowired
	private TransacaoService transacaoService;

	@Autowired
	private View jsonView_i;

	private static final String DATA_FIELD = "data";
	private static final String ERROR_FIELD = "error";

	private static final Logger logger_c = Logger.getLogger( TransacaoController.class );
	
	@RequestMapping( value = "/rest/transacao/{Id}", method = RequestMethod.GET )
	public  ModelAndView getFund( @PathVariable( "Id" ) String id ) {
		TransacaoPO transacao = null;

		if ( isEmpty( id ) ) {
			String sMessage = "Error invoking getFund - Invalid fund Id parameter";
			return createErrorResponse( sMessage );
		}

		try {
			transacaoService.getFundById(id);
		} catch ( Exception e ) {
			String sMessage = "Error invoking getFund. [%1$s]";
			return createErrorResponse( String.format( sMessage, e.toString() ) );
		}

		logger_c.debug( "Returing Fund: " + transacao.toString() );
		return new ModelAndView( jsonView_i, DATA_FIELD, transacao );
	}
	
	@RequestMapping(value = "/rest/transacao/", method = RequestMethod.GET)
	public ModelAndView getUsuarios() {
		List<TransacaoPO> transacoes = null;

		try {
			transacoes = transacaoService.getAllFunds();
		} catch (Exception e) {
			String sMessage = "Error getting all funds. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		logger_c.debug("Returing Funds: " + transacoes.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, transacoes);
	}
	
	@RequestMapping(value = { "/rest/transacao/" }, method = { RequestMethod.POST })
	public ModelAndView createFund(@RequestBody TransacaoPO transacao,
			HttpServletResponse httpResponse, WebRequest request) {


		try {
			transacaoService.createFund(transacao);
		} catch (Exception e) {
			String sMessage = "Error creating new fund. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

	
		httpResponse.setStatus(HttpStatus.CREATED.value());

	
		httpResponse.setHeader("Location", request.getContextPath() + "/rest/transacao/" + transacao.getId());

	
		return new ModelAndView(jsonView_i, DATA_FIELD, transacao);
	}
	
	public static boolean isEmpty(String s_p) {
		return (null == s_p) || s_p.trim().length() == 0;
	}
	
	private ModelAndView createErrorResponse( String sMessage ) {
		return new ModelAndView( jsonView_i, ERROR_FIELD, sMessage );
	}
	
	public void setJsonView(View view) {
		jsonView_i = view;
	}
	
	public void setUsuarioService(TransacaoService transacao) {
		this.transacaoService = transacao;
	}
	
}
