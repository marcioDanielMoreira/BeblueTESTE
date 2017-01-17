package com.teste.samples.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.teste.samples.abstracts.AbstractDAO;
import com.teste.samples.domain.EstabelecimentoPO;
import com.teste.samples.exceptions.ApplicationException;

public class EstabelecimentoDAO extends AbstractDAO<EstabelecimentoPO> {

	@Override
	public ArrayList< EstabelecimentoPO > filtrar( EstabelecimentoPO poFiltrar ) throws ApplicationException {
		try {
			Criteria criteria = this.sessaoCorrente.createCriteria( EstabelecimentoPO.class );

			/*MONTANDO AS RESTRIÇÕES DINAMICAS*/
			if ( poFiltrar.getSegunda() != null ) {
				criteria.add( Restrictions.eq( "segunda", poFiltrar.getSegunda() ) );
			}

			if ( poFiltrar.getTerca() != null ) {
				criteria.add( Restrictions.eq( "terca", poFiltrar.getTerca() ) );
			}

			if ( poFiltrar.getQuarta() != null ) {
				criteria.add( Restrictions.eq( "quarta", poFiltrar.getQuarta() ) );
			}

			if ( poFiltrar.getQuinta() != null ) {
				criteria.add( Restrictions.eq( "quinta", poFiltrar.getQuinta() ) );
			}

			if ( poFiltrar.getSexta() != null ) {
				criteria.add( Restrictions.eq( "sexta", poFiltrar.getSexta() ) );
			}

			if ( poFiltrar.getSabado() != null ) {
				criteria.add( Restrictions.eq( "sabado", poFiltrar.getSabado() ) );
			}

			if ( poFiltrar.getDomingo() != null ) {
				criteria.add( Restrictions.eq( "domingo", poFiltrar.getDomingo() ) );
			}

			return (ArrayList< EstabelecimentoPO >) criteria.list();
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	
}
