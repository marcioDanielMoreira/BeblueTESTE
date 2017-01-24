package com.teste.samples.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.teste.samples.controller.UsuarioFACADE;
import com.teste.samples.domain.UsuarioPO;
import com.teste.samples.exceptions.ApplicationException;

@Service
public class UsuarioService {

	public void getUserById(String id) throws NumberFormatException, ApplicationException {
		UsuarioFACADE facade = new UsuarioFACADE();

		facade.filtrarPorId(UsuarioPO.class, new Long(id));

	}

	public List<UsuarioPO> getAllUsers() throws ApplicationException {
		List<UsuarioPO> usuarios = new ArrayList<UsuarioPO>();
		
		for (int i = 0; i < 10; i++) {
			UsuarioFACADE facade = new UsuarioFACADE();
			usuarios = facade.filtrarTudo(UsuarioPO.class);
		}

		return usuarios;
	}

	public void createUser(UsuarioPO usuario) throws ApplicationException {
		RestTemplate restTemplate = new RestTemplate();
		
		UsuarioPO[] pojos = restTemplate.getForObject(
				"https://quarkbackend.com/getfile/vilibaldo-neto/json-javatest-users",
				UsuarioPO[].class);
		
		ArrayList<UsuarioPO> usuarios = new ArrayList<UsuarioPO>(Arrays.asList(pojos));

		UsuarioFACADE facade = new UsuarioFACADE();
		
		UsuarioPO usuarioEncontrado = new UsuarioPO();
		for (UsuarioPO usuarioPOCorrente : usuarios) {
			
			usuarioEncontrado = facade.filtrarPorCPF(UsuarioPO.class, usuarioPOCorrente.getUser_cpf());
			if(usuarioEncontrado == null){
				facade.inserir(usuarioPOCorrente);
			}
		}
		usuarioEncontrado = facade.filtrarPorCPF(UsuarioPO.class, usuario.getUser_cpf());
		if(usuarioEncontrado == null){
			facade.inserir(usuario);
		}
	}
}
