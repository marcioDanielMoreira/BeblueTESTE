package com.teste.samples.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.teste.samples.abstracts.AbstractPO;
import com.teste.samples.web.utils.DateSerializer;

@Entity
@Table( name = "transacoes" )
public final class TransacaoPO extends AbstractPO {

	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "date", nullable = false )
	private Date date;

	@Column( name = "transaction_value", nullable = false )
	private Double transaction_value;

	@ManyToOne( fetch = FetchType.EAGER ) //Padrão quando for ManyToOne
	@JoinColumn( name = "user_cpf", nullable = false ) //ToOne VEM
	private UsuarioPO user_cpf;

	@Column( name = "code", nullable = false )
	private String code;

	@OneToOne( fetch = FetchType.EAGER ) //Padrão quando for OneToOne
	@JoinColumn( name = "transaction_type", nullable = true ) //ToOne VEM
	private String transaction_type;

	@ManyToOne( fetch = FetchType.EAGER ) //Padrão quando for ManyToOne
	@JoinColumn( name = "merchant_id", nullable = false ) //ToOne VEM
	private EstabelecimentoPO merchant_id;

	public TransacaoPO(){}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type( TipotransacaoPO transaction_type ) {
		this.transaction_type = transaction_type.getTransaction_type();
	}

	public EstabelecimentoPO getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id( EstabelecimentoPO merchant_id ) {
		this.merchant_id = merchant_id;
	}

	@JsonSerialize(using=DateSerializer.class)
	public Date getDate() {
		return date;
	}

	@JsonSerialize(using=DateSerializer.class)
	public void setDate( Date date ) {
		this.date = date;
	}

	public UsuarioPO getUsuario() {
		return user_cpf;
	}

	public void setUsuario( UsuarioPO usuario ) {
		this.user_cpf = usuario;
	}

	public String getCode() {
		return code;
	}

	public void setCode( String code ) {
		this.code = code;
	}

	public Double getValue() {
		return transaction_value;
	}

	public void setValue( Double value ) {
		this.transaction_value = value;
	}

	@Override
	public String toString() {
		return "TransacaoPO [date=" + date + ", value=" + transaction_value + ", usuario=" + user_cpf + ", code=" + code + ", transaction_type=" + transaction_type + ", merchant_id=" + merchant_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( code == null ) ? 0 : code.hashCode() );
		result = prime * result + ( ( date == null ) ? 0 : date.hashCode() );
		result = prime * result + ( ( merchant_id == null ) ? 0 : merchant_id.hashCode() );
		result = prime * result + ( ( transaction_type == null ) ? 0 : transaction_type.hashCode() );
		result = prime * result + ( ( user_cpf == null ) ? 0 : user_cpf.hashCode() );
		result = prime * result + ( ( transaction_value == null ) ? 0 : transaction_value.hashCode() );
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
		if ( !( obj instanceof TransacaoPO ) ) {
			return false;
		}
		TransacaoPO other = (TransacaoPO) obj;
		if ( code == null ) {
			if ( other.code != null ) {
				return false;
			}
		} else if ( !code.equals( other.code ) ) {
			return false;
		}
		if ( date == null ) {
			if ( other.date != null ) {
				return false;
			}
		} else if ( !date.equals( other.date ) ) {
			return false;
		}
		if ( merchant_id == null ) {
			if ( other.merchant_id != null ) {
				return false;
			}
		} else if ( !merchant_id.equals( other.merchant_id ) ) {
			return false;
		}
		if ( transaction_type == null ) {
			if ( other.transaction_type != null ) {
				return false;
			}
		} else if ( !transaction_type.equals( other.transaction_type ) ) {
			return false;
		}
		if ( user_cpf == null ) {
			if ( other.user_cpf != null ) {
				return false;
			}
		} else if ( !user_cpf.equals( other.user_cpf ) ) {
			return false;
		}
		if ( transaction_value == null ) {
			if ( other.transaction_value != null ) {
				return false;
			}
		} else if ( !transaction_value.equals( other.transaction_value ) ) {
			return false;
		}
		return true;
	}

}
