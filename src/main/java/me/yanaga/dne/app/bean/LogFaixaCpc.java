package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class LogFaixaCpc implements Serializable {

	@EmbeddedId
	private LogFaixaCpcPK id;

	@Column(insertable = false, updatable = false)
	private Integer cpcNu;

	@Column(insertable = false, updatable = false)
	private String cpcInicial;

	@Column(length = 6, nullable = false)
	private String cpcFinal;

	public LogFaixaCpcPK getId() {
		return id;
	}

	public void setId(LogFaixaCpcPK id) {
		this.id = id;
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

	public String getCpcFinal() {
		return cpcFinal;
	}

	public void setCpcFinal(String cpcFinal) {
		this.cpcFinal = cpcFinal;
	}
}

