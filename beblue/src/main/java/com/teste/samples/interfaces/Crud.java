package com.teste.samples.interfaces;

import java.util.ArrayList;

import com.teste.samples.exceptions.ApplicationException;

public interface Crud<T> {

	void inserir( T po ) throws ApplicationException;

	@SuppressWarnings( "rawtypes" )
	ArrayList< T > filtrarTudo( Class clazz ) throws ApplicationException;

	@SuppressWarnings( "rawtypes" )
	T filtrarPorId( Class clazz, Long id ) throws ApplicationException;

	ArrayList< T > filtrar( T poFiltrar ) throws ApplicationException;
	
}
