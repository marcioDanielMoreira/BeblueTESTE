package com.teste.samples.domain;

public final class TipotransacaoPOJO  {

	public static final String CASHBACK = "CASHBACK";
	
	private String transaction_type;

	
	private String transaction_name;

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type( String transaction_type ) {
		this.transaction_type = transaction_type;
	}

	public String getTransaction_name() {
		return transaction_name;
	}

	public void setTransaction_name( String transaction_name ) {
		this.transaction_name = transaction_name;
	}

	@Override
	public String toString() {
		return "tipotransacaoPO [transaction_type=" + transaction_type + ", transaction_name=" + transaction_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( transaction_name == null ) ? 0 : transaction_name.hashCode() );
		result = prime * result + ( ( transaction_type == null ) ? 0 : transaction_type.hashCode() );
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj ) {
			return true;
		}
		if ( obj == null ) {
			return false;
		}
		if ( !( obj instanceof TipotransacaoPOJO ) ) {
			return false;
		}
		TipotransacaoPOJO other = (TipotransacaoPOJO) obj;
		if ( transaction_name == null ) {
			if ( other.transaction_name != null ) {
				return false;
			}
		} else if ( !transaction_name.equals( other.transaction_name ) ) {
			return false;
		}
		if ( transaction_type == null ) {
			if ( other.transaction_type != null ) {
				return false;
			}
		} else if ( !transaction_type.equals( other.transaction_type ) ) {
			return false;
		}
		return true;
	}

}
