package com.teste.samples.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.teste.samples.controller.UsuarioFACADE;
import com.teste.samples.domain.UsuarioPO;
import com.teste.samples.exceptions.ApplicationException;

@Service
public class UsuarioService {
	
	
	public void getFundById(String id) throws NumberFormatException, ApplicationException {
		UsuarioFACADE facade = new UsuarioFACADE();

		facade.filtrarPorId(UsuarioPO.class, new Long(id));
		
	}
	
	public List<UsuarioPO> getAllFunds() throws ApplicationException {
		List<UsuarioPO> usuarios = new ArrayList<UsuarioPO>();

		for (int i = 0; i < 10; i++) {
			UsuarioFACADE facade = new UsuarioFACADE();

			usuarios = facade.filtrarTudo(UsuarioPO.class);
			
		}

		return usuarios;
	}
	
	public void createFund(UsuarioPO usuario) throws ApplicationException {


		UsuarioFACADE facade = new UsuarioFACADE();
		facade.inserir(usuario);
	
	}
}
