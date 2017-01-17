package com.teste.samples.exceptions;

public final class ApplicationException extends Exception {

	private static final long serialVersionUID = 7809812878958961387L;

	public ApplicationException( String message ){
		super( message );
	}

	public ApplicationException( String message, Throwable cause ){
		super( message, cause );
	}
	
}
