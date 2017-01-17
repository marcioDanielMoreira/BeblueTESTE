package com.teste.samples.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.teste.samples.abstracts.AbstractPO;

@Entity
@Table(name = "estabelecimentos")
public final class EstabelecimentoPO extends AbstractPO {

	@Column(name = "segunda", nullable = false)
	private Double segunda;

	@Column(name = "terca", nullable = false)
	private Double terca;

	@Column(name = "quarta", nullable = false)
	private Double quarta;

	@Column(name = "quinta", nullable = false)
	private Double quinta;

	@Column(name = "sexta", nullable = false)
	private Double sexta;

	@Column(name = "sabado", nullable = false)
	private Double sabado;

	@Column(name = "domingo", nullable = false)
	private Double domingo;

	public EstabelecimentoPO(Double segunda, Double terca, Double quarta, Double quinta, Double sexta, Double sabado,
			Double domingo) {
		setDomingo(domingo);
		setSegunda(segunda);
		setTerca(terca);
		setQuarta(quarta);
		setQuinta(quinta);
		setSexta(sexta);
		setSabado(sabado);
	}

	public EstabelecimentoPO() {
	}

	public Double getSegunda() {
		return segunda;
	}

	public void setSegunda(Double segunda) {
		this.segunda = segunda;
	}

	public Double getTerca() {
		return terca;
	}

	public void setTerca(Double terca) {
		this.terca = terca;
	}

	public Double getQuarta() {
		return quarta;
	}

	public void setQuarta(Double quarta) {
		this.quarta = quarta;
	}

	public Double getQuinta() {
		return quinta;
	}

	public void setQuinta(Double quinta) {
		this.quinta = quinta;
	}

	public Double getSexta() {
		return sexta;
	}

	public void setSexta(Double sexta) {
		this.sexta = sexta;
	}

	public Double getSabado() {
		return sabado;
	}

	public void setSabado(Double sabado) {
		this.sabado = sabado;
	}

	public Double getDomingo() {
		return domingo;
	}

	public void setDomingo(Double domingo) {
		this.domingo = domingo;
	}

	@Override
	public String toString() {
		return "EstabelecimentoPO [segunda=" + segunda + ", terca=" + terca + ", quarta=" + quarta + ", quinta="
				+ quinta + ", sexta=" + sexta + ", sabado=" + sabado + ", domingo=" + domingo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domingo == null) ? 0 : domingo.hashCode());
		result = prime * result + ((quarta == null) ? 0 : quarta.hashCode());
		result = prime * result + ((quinta == null) ? 0 : quinta.hashCode());
		result = prime * result + ((sabado == null) ? 0 : sabado.hashCode());
		result = prime * result + ((segunda == null) ? 0 : segunda.hashCode());
		result = prime * result + ((sexta == null) ? 0 : sexta.hashCode());
		result = prime * result + ((terca == null) ? 0 : terca.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EstabelecimentoPO)) {
			return false;
		}
		EstabelecimentoPO other = (EstabelecimentoPO) obj;
		if (domingo == null) {
			if (other.domingo != null) {
				return false;
			}
		} else if (!domingo.equals(other.domingo)) {
			return false;
		}
		if (quarta == null) {
			if (other.quarta != null) {
				return false;
			}
		} else if (!quarta.equals(other.quarta)) {
			return false;
		}
		if (quinta == null) {
			if (other.quinta != null) {
				return false;
			}
		} else if (!quinta.equals(other.quinta)) {
			return false;
		}
		if (sabado == null) {
			if (other.sabado != null) {
				return false;
			}
		} else if (!sabado.equals(other.sabado)) {
			return false;
		}
		if (segunda == null) {
			if (other.segunda != null) {
				return false;
			}
		} else if (!segunda.equals(other.segunda)) {
			return false;
		}
		if (sexta == null) {
			if (other.sexta != null) {
				return false;
			}
		} else if (!sexta.equals(other.sexta)) {
			return false;
		}
		if (terca == null) {
			if (other.terca != null) {
				return false;
			}
		} else if (!terca.equals(other.terca)) {
			return false;
		}
		return true;
	}

}
