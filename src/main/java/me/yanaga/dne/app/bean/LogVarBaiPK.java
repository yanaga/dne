package me.yanaga.dne.app.bean;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LogVarBaiPK implements Serializable {

	@Column(nullable = false)
	private Integer baiNu;

	@Column(nullable = false)
	private Integer vdbNu;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LogVarBaiPK) {
			LogVarBaiPK other = (LogVarBaiPK) obj;
			return Objects.equal(this.baiNu, other.baiNu)
					&& Objects.equal(this.vdbNu, other.vdbNu);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.baiNu, this.vdbNu);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("baiNu", this.baiNu)
				.add("vdbNu", this.vdbNu)
				.toString();
	}

	public Integer getBaiNu() {
		return baiNu;
	}

	public void setBaiNu(Integer baiNu) {
		this.baiNu = baiNu;
	}

	public Integer getVdbNu() {
		return vdbNu;
	}

	public void setVdbNu(Integer vdbNu) {
		this.vdbNu = vdbNu;
	}
}
