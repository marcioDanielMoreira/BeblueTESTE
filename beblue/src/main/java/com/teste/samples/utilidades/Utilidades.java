package com.teste.samples.utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Utilidades {
	
	public static final String SCHEMA = "beblue";

	public static final Date parseDate( String data ) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
		sdf.setLenient( false );
		return sdf.parse( data );
	}

	public static final String parseDate( Date data ) {
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
		sdf.setLenient( false );
		return sdf.format( data );
	}

	public static final String generateCodigoGrande() {//1475038593343260475265245324832E17
		String valor = String.valueOf( new java.util.Date().getTime() ) + String.valueOf( Math.random() * 99L ).replace( ".", "" );
		return valor;
	}

}
