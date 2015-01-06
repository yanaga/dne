package me.yanaga.dne.app.bean;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

public class LogVarLogPK implements Serializable {

	private Integer logNu;

	private Integer vloNu;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LogVarLogPK) {
			LogVarLogPK other = (LogVarLogPK) obj;
			return Objects.equal(this.logNu, other.logNu)
					&& Objects.equal(this.vloNu, other.vloNu);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.logNu, this.vloNu);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("logNu", this.logNu)
				.add("vloNu", this.vloNu)
				.toString();
	}

	public Integer getLogNu() {
		return logNu;
	}

	public void setLogNu(Integer logNu) {
		this.logNu = logNu;
	}

	public Integer getVloNu() {
		return vloNu;
	}

	public void setVloNu(Integer vloNu) {
		this.vloNu = vloNu;
	}
}
