package com.teste.samples.abstracts;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teste.samples.exceptions.ApplicationException;
import com.teste.samples.interfaces.Crud;

@Repository
public class AbstractDAO<T> implements Crud<T> {

	private static final SessionFactory SESSION_FACTORY;
	protected Session sessaoCorrente;
	private Transaction transacao;

	/**
	 * Bloco estático responsável por carregar um objeto "Configuration" com os
	 * dados configurados na TAG (<hibernate-configuration>) do arquivo
	 * hibernate.cfg.xml PS: Bloco estático garante que seu conteúdo seja
	 * executado pelo meno uma(1) vez ao instanciar a classe onde foi escrito.
	 */
	static {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties())
				.buildServiceRegistry();
		SESSION_FACTORY = cfg.buildSessionFactory(serviceRegistry);
	}

	private final void abrirSessao() {
		if (SESSION_FACTORY != null) {
			this.sessaoCorrente = SESSION_FACTORY.openSession();
		}
	}

	private final void fecharSessao() {
		if (this.sessaoCorrente != null) {
			this.sessaoCorrente.close();
			this.sessaoCorrente = null;
		}
	}

	public final void iniciarTransacao() {
		this.abrirSessao();
		this.transacao = this.sessaoCorrente.beginTransaction();
	}

	public final void confirmarTransacao() {
		if (this.transacao != null) {
			this.transacao.commit();
			this.fecharSessao();
			this.transacao = null;
		}
	}

	public final void desfazerTransacao() {
		if (this.transacao != null) {
			this.transacao.rollback();
			this.fecharSessao();
			this.transacao = null;
		}
	}

	
	public void inserir(T po) throws ApplicationException {
		try {
			AbstractPO inserido = (AbstractPO) this.sessaoCorrente.merge(po);
		} catch (ConstraintViolationException e) {
			throw new ApplicationException("Registro duplicado", e);
		} catch (Exception e) {
			throw new ApplicationException("Erro desconhecido", e);
		}
	}

	
	public ArrayList<T> filtrarTudo(Class clazz) throws ApplicationException {
		try {
			Criteria criteria = this.sessaoCorrente.createCriteria( clazz );
			criteria.addOrder( Order.desc( "id" ) );

			return (ArrayList< T >) criteria.list();
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	
	public T filtrarPorId(Class clazz, Long id) throws ApplicationException {
		try {

			Criteria criteria = this.sessaoCorrente.createCriteria( clazz );
			criteria.add( Restrictions.idEq( id ) );

			return (T) criteria.uniqueResult();
		} catch ( Exception e ) {
			throw new ApplicationException( "Erro desconhecido", e );
		}
	}

	public ArrayList<T> filtrar(T poFiltrar) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
