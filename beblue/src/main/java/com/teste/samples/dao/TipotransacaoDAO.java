package com.teste.samples.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.teste.samples.abstracts.AbstractDAO;
import com.teste.samples.domain.TipotransacaoPO;
import com.teste.samples.exceptions.ApplicationException;

public class TipotransacaoDAO extends AbstractDAO<TipotransacaoPO> {

	@Override
	public ArrayList< TipotransacaoPO > filtrar( TipotransacaoPO poFiltrar ) throws ApplicationException {
		Criteria criteria = this.sessaoCorrente.createCriteria( TipotransacaoPO.class );
		try {

			/*MONTANDO AS RESTRIÇÕES DINAMICAS*/
			if ( poFiltrar.getTransaction_type() != null ) {
				criteria.add( Restrictions.eq( "transaction_type", poFiltrar.getTransaction_type() ) );
			}

			if ( poFiltrar.getTransaction_name() != null ) {
				criteria.add( Restrictions.eq( "transaction_name", poFiltrar.getTransaction_name() ) );
			}

			return (ArrayList< TipotransacaoPO >) criteria.list();
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}
	
	public TipotransacaoPO filtrarPorTipo(Class clazz, String tipo) throws ApplicationException {
		try {

			Criteria criteria = this.sessaoCorrente.createCriteria( clazz );
			criteria.add( Restrictions.like( "trasaction_type", tipo, MatchMode.START ) );

			return (TipotransacaoPO) criteria.uniqueResult();
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}
}
