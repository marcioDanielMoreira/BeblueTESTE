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

import com.teste.samples.domain.UsuarioPO;
import com.teste.samples.services.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private View jsonView_i;

	private static final String DATA_FIELD = "data";
	private static final String ERROR_FIELD = "error";

	private static final Logger logger_c = Logger.getLogger( UsuarioController.class );
	
	@RequestMapping( value = "/rest/users/{userId}", method = RequestMethod.GET )
	public  ModelAndView getFund( @PathVariable( "userId" ) String id ) {
		UsuarioPO usuario = null;

		if ( isEmpty( id ) ) {
			String sMessage = "Error invoking getFund - Invalid fund Id parameter";
			return createErrorResponse( sMessage );
		}

		try {
			usuarioService.getUserById(id);
		} catch ( Exception e ) {
			String sMessage = "Error invoking getFund. [%1$s]";
			return createErrorResponse( String.format( sMessage, e.toString() ) );
		}

		logger_c.debug( "Returing Users: " + usuario.toString() );
		return new ModelAndView( jsonView_i, DATA_FIELD, usuario );
	}
	
	@RequestMapping(value = "/rest/users/", method = RequestMethod.GET)
	public ModelAndView getUsuarios() {
		List<UsuarioPO> usuarios = null;

		try {
			usuarios = usuarioService.getAllUsers();
		} catch (Exception e) {
			String sMessage = "Error getting all funds. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		logger_c.debug("Returing Users: " + usuarios.toString());
		return new ModelAndView(jsonView_i, DATA_FIELD, usuarios);
	}
	
	@RequestMapping(value = { "/rest/register-users/" }, method = { RequestMethod.POST })
	public ModelAndView createFund(@RequestBody UsuarioPO user,
			HttpServletResponse httpResponse, WebRequest request) {


		try {
			usuarioService.createUser(user);
		} catch (Exception e) {
			String sMessage = "Error creating new fund. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		
		httpResponse.setStatus(HttpStatus.CREATED.value());

	
		httpResponse.setHeader("Location", request.getContextPath() + "/rest/users/" + user.getId());

		
		return new ModelAndView(jsonView_i, DATA_FIELD, user);
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
	
	public void setUsuarioService(UsuarioService usuario) {
		this.usuarioService = usuario;
	}

}
