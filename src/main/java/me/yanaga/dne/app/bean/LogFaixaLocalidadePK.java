package me.yanaga.dne.app.bean;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LogFaixaLocalidadePK implements Serializable {

	@Column(nullable = false)
	private Integer locNu;

	@Column(length = 8, nullable = false)
	private String locCepIni;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LogFaixaLocalidadePK) {
			LogFaixaLocalidadePK other = (LogFaixaLocalidadePK) obj;
			return Objects.equal(this.locNu, other.locNu)
					&& Objects.equal(this.locCepIni, other.locCepIni);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.locNu, this.locCepIni);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("locNu", this.locNu)
				.add("locCepIni", this.locCepIni)
				.toString();
	}

	public Integer getLocNu() {
		return locNu;
	}

	public void setLocNu(Integer locNu) {
		this.locNu = locNu;
	}

	public String getLocCepIni() {
		return locCepIni;
	}

	public void setLocCepIni(String locCepIni) {
		this.locCepIni = locCepIni;
	}
}
