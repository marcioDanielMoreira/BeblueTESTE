package com.teste.samples.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.teste.samples.abstracts.AbstractDAO;
import com.teste.samples.domain.TransacaoPO;
import com.teste.samples.exceptions.ApplicationException;

public final class TransacaoDAO extends AbstractDAO<TransacaoPO> {

	@SuppressWarnings( "unchecked" )
	@Override
	public ArrayList< TransacaoPO > filtrar( TransacaoPO poFiltrar ) throws ApplicationException {
		try {
			Criteria criteria = this.sessaoCorrente.createCriteria( TransacaoPO.class );

			/*MONTANDO AS RESTRIÇÕES DINAMICAS*/
			if ( poFiltrar.getDate() != null ) {
				criteria.add( Restrictions.eq( "date", poFiltrar.getDate() ) );
			}

			if ( poFiltrar.getTransaction_type() != null ) {
				criteria.add( Restrictions.eq( "transaction_type", poFiltrar.getTransaction_type() ) );
			}

			if ( poFiltrar.getValue() != null ) {
				criteria.add( Restrictions.eq( "transaction_value", poFiltrar.getValue() ) );
			}

			if ( poFiltrar.getUsuario() != null ) {
				criteria.add( Restrictions.eq( "user", poFiltrar.getUsuario() ) );
			}

			if ( poFiltrar.getCode() != null ) {
				criteria.add( Restrictions.like( "code", poFiltrar.getCode(), MatchMode.START ) );
			}

			if ( poFiltrar.getId() != null ) {
				criteria.add( Restrictions.idEq( poFiltrar.getId() ) );
			}

			if ( poFiltrar.getMerchant_id() != null ) {
				criteria.add( Restrictions.eq( "merchant_id", poFiltrar.getMerchant_id() ) );
			}

			return (ArrayList< TransacaoPO >) criteria.list();
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}
	
}
