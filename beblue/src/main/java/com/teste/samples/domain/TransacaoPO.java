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
@Table(name = "transacoes")
public final class TransacaoPO extends AbstractPO {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "transaction_value", nullable = false)
	private Double transaction_value;

	@Column(name = "user_cpf", nullable = false)
	private String user_cpf;

	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "transaction_type", nullable = false)
	private String transaction_type;

	@Column(name = "merchant_id", nullable = false)
	private Long merchant_id;

	public TransacaoPO(String user_cpf, Long merchant_id, Double transaction_value, String transaction_type) {
		setUser_cpf(user_cpf);
		setMerchant_id(merchant_id);
		setTransaction_value(transaction_value);
		setTransaction_type(transaction_type);
	}

	public TransacaoPO() {
	}

	public void setMerchant_id(Long merchant_id) {
		this.merchant_id = merchant_id;
	}

	public Double getTransaction_value() {
		return transaction_value;
	}

	public void setTransaction_value(Double transaction_value) {
		this.transaction_value = transaction_value;
	}

	

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public Long getMerchant_id() {
		return merchant_id;
	}

	public String getUser_cpf() {
		return user_cpf;
	}

	public void setUser_cpf(String user_cpf) {
		this.user_cpf = user_cpf;
	}

	@JsonSerialize(using = DateSerializer.class)
	public Date getDate() {
		return date;
	}

	@JsonSerialize(using = DateSerializer.class)
	public void setDate(Date date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	@Override
	public String toString() {
		return "TransacaoPO [date=" + date + ", transaction_value=" + transaction_value + ", user_cpf=" + user_cpf
				+ ", code=" + code + ", transaction_type=" + transaction_type + ", merchant_id=" + merchant_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((merchant_id == null) ? 0 : merchant_id.hashCode());
		result = prime * result + ((transaction_type == null) ? 0 : transaction_type.hashCode());
		result = prime * result + ((transaction_value == null) ? 0 : transaction_value.hashCode());
		result = prime * result + ((user_cpf == null) ? 0 : user_cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransacaoPO other = (TransacaoPO) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (merchant_id == null) {
			if (other.merchant_id != null)
				return false;
		} else if (!merchant_id.equals(other.merchant_id))
			return false;
		if (transaction_type == null) {
			if (other.transaction_type != null)
				return false;
		} else if (!transaction_type.equals(other.transaction_type))
			return false;
		if (transaction_value == null) {
			if (other.transaction_value != null)
				return false;
		} else if (!transaction_value.equals(other.transaction_value))
			return false;
		if (user_cpf == null) {
			if (other.user_cpf != null)
				return false;
		} else if (!user_cpf.equals(other.user_cpf))
			return false;
		return true;
	}

}
