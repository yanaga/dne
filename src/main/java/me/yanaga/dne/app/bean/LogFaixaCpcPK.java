package me.yanaga.dne.app.bean;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

public class LogFaixaCpcPK implements Serializable {

	private Integer cpcNu;

	private String cpcInicial;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LogFaixaCpcPK) {
			LogFaixaCpcPK other = (LogFaixaCpcPK) obj;
			return Objects.equal(this.cpcNu, other.cpcNu)
					&& Objects.equal(this.cpcInicial, other.cpcInicial);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.cpcNu, this.cpcInicial);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("cpcNu", this.cpcNu)
				.add("cpcInicial", this.cpcInicial)
				.toString();
	}

	public Integer getCpcNu() {
		return cpcNu;
	}

	public void setCpcNu(Integer cpcNu) {
		this.cpcNu = cpcNu;
	}

	public String getCpcInicial() {
		return cpcInicial;
	}

	public void setCpcInicial(String cpcInicial) {
		this.cpcInicial = cpcInicial;
	}
}
