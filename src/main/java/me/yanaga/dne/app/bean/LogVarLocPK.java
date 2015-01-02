package me.yanaga.dne.app.bean;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LogVarLocPK implements Serializable {

	@Column(nullable = false)
	private Integer locNu;

	@Column(nullable = false)
	private Integer valNu;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LogVarLocPK) {
			LogVarLocPK other = (LogVarLocPK) obj;
			return Objects.equal(this.locNu, other.locNu)
					&& Objects.equal(this.valNu, other.valNu);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.locNu, this.valNu);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("locNu", this.locNu)
				.add("valNu", this.valNu)
				.toString();
	}

	public Integer getLocNu() {
		return locNu;
	}

	public void setLocNu(Integer locNu) {
		this.locNu = locNu;
	}

	public Integer getValNu() {
		return valNu;
	}

	public void setValNu(Integer valNu) {
		this.valNu = valNu;
	}
}
