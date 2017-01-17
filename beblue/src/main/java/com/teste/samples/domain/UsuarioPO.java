package com.teste.samples.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.teste.samples.abstracts.AbstractPO;
import com.teste.samples.utilidades.Utilidades;

@Entity
@Table(name = "usuarios", schema = Utilidades.SCHEMA, uniqueConstraints = @UniqueConstraint(columnNames = {
		"user_cpf" }))
public class UsuarioPO extends AbstractPO {

	@Column( name = "user_cpf", nullable = false )
	private String user_cpf;

	@Column( name = "name", nullable = false )
	private String name;

	@Column( name = "balance", nullable = false )
	private Double balance;

	/** Método Construtor */



	/** Get and Set */

	public String getUser_cpf() {
		return user_cpf;
	}

	public void setUser_cpf( String user_cpf ) {
		this.user_cpf = user_cpf;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance( Double balance ) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "UsuarioPO [user_cpf=" + user_cpf + ", name=" + name + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( balance == null ) ? 0 : balance.hashCode() );
		result = prime * result + ( ( name == null ) ? 0 : name.hashCode() );
		result = prime * result + ( ( user_cpf == null ) ? 0 : user_cpf.hashCode() );
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
		if ( !( obj instanceof UsuarioPO ) ) {
			return false;
		}
		UsuarioPO other = (UsuarioPO) obj;
		if ( balance == null ) {
			if ( other.balance != null ) {
				return false;
			}
		} else if ( !balance.equals( other.balance ) ) {
			return false;
		}
		if ( name == null ) {
			if ( other.name != null ) {
				return false;
			}
		} else if ( !name.equals( other.name ) ) {
			return false;
		}
		if ( user_cpf == null ) {
			if ( other.user_cpf != null ) {
				return false;
			}
		} else if ( !user_cpf.equals( other.user_cpf ) ) {
			return false;
		}
		return true;
	}

}
