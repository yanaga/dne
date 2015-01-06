package me.yanaga.dne.app.bean;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

public class LogFaixaUopPK implements Serializable {

	private Integer uopNu;

	private Integer fncInicial;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LogFaixaUopPK) {
			LogFaixaUopPK other = (LogFaixaUopPK) obj;
			return Objects.equal(this.uopNu, other. uopNu)
					&& Objects.equal(this.fncInicial, other.fncInicial);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.uopNu, this.fncInicial);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("uopNu", this.uopNu)
				.add("fncInicial", this.fncInicial)
				.toString();
	}

	public Integer getUopNu() {
		return uopNu;
	}

	public void setUopNu(Integer uopNu) {
		this.uopNu = uopNu;
	}

	public Integer getFncInicial() {
		return fncInicial;
	}

	public void setFncInicial(Integer fncInicial) {
		this.fncInicial = fncInicial;
	}
}
