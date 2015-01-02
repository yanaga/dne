package me.yanaga.dne.app.bean;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LogFaixaBairroPK implements Serializable {

	@Column(nullable = false)
	private Integer baiNu;

	@Column(length = 8, nullable = false)
	private String fcbCepIni;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LogFaixaBairroPK) {
			LogFaixaBairroPK other = (LogFaixaBairroPK) obj;
			return Objects.equal(this.baiNu, other.baiNu)
					&& Objects.equal(this.fcbCepIni, other.fcbCepIni);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.baiNu, this.fcbCepIni);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("baiNu", this.baiNu)
				.add("fcbCepIni", this.fcbCepIni)
				.toString();
	}

	public Integer getBaiNu() {
		return baiNu;
	}

	public void setBaiNu(Integer baiNu) {
		this.baiNu = baiNu;
	}

	public String getFcbCepIni() {
		return fcbCepIni;
	}

	public void setFcbCepIni(String fcbCepIni) {
		this.fcbCepIni = fcbCepIni;
	}
}
