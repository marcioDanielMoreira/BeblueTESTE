package com.teste.samples.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

import com.teste.samples.abstracts.AbstractDAO;
import com.teste.samples.domain.UsuarioPO;
import com.teste.samples.exceptions.ApplicationException;

@Repository
public class UsuarioDAO extends AbstractDAO<UsuarioPO> {
	
	@SuppressWarnings( "unchecked" )
	@Override
	public ArrayList< UsuarioPO > filtrar( UsuarioPO poFiltrar ) throws ApplicationException {
		try {
			Criteria criteria = this.sessaoCorrente.createCriteria( UsuarioPO.class );

			/*MONTANDO AS RESTRIÇÕES DINAMICAS*/
			if ( poFiltrar.getUser_cpf() != null ) {
				criteria.add( Restrictions.like( "user_cpf", poFiltrar.getUser_cpf(), MatchMode.START ) );
			}

			if ( poFiltrar.getName() != null ) {
				criteria.add( Restrictions.like( "name", poFiltrar.getName(), MatchMode.START ) );
			}

			if ( poFiltrar.getBalance() != null ) {
				criteria.add( Restrictions.eq( "balance", poFiltrar.getBalance() ) );
			}

			if ( poFiltrar.getId() != null ) {
				criteria.add( Restrictions.idEq( poFiltrar.getId() ) );
			}

			return (ArrayList< UsuarioPO >) criteria.list();
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	public void alterar( UsuarioPO po ) throws ApplicationException {
		try {

			UsuarioPO inserido = (UsuarioPO) sessaoCorrente.merge( po );
			UsuarioPO poOriginal = (UsuarioPO) po;
			poOriginal.setId( inserido.getId() );

		} catch ( ConstraintViolationException e ) {
			throw new ApplicationException( "Registro duplicado", e );
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}
	
	public UsuarioPO filtrarPorCPF(Class clazz, String cpf) throws ApplicationException {
		try {

			Criteria criteria = this.sessaoCorrente.createCriteria( clazz );
			criteria.add( Restrictions.eq("user_cpf", cpf ) );

			return (UsuarioPO) criteria.uniqueResult();
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}
	
}
