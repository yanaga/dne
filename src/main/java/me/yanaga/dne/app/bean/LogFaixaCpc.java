package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(LogFaixaCpcPK.class)
public class LogFaixaCpc implements Serializable {

	@Id
	@Column(nullable = false)
	private Integer cpcNu;

	@Id
	@Column(length = 6, nullable = false)
	private String cpcInicial;

	@Column(length = 6, nullable = false)
	private String cpcFinal;

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

