package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class EctPais implements Serializable {

	@Id
	@Column(length = 2, nullable = false)
	private String paiSg;

	@Column(length = 3, nullable = false)
	private String paiSgAlternativa;

	@Column(length = 72, nullable = false)
	private String paiNoPortugues;

	@Column(length = 72, nullable = false)
	private String paiNoIngles;

	@Column(length = 72, nullable = false)
	private String paiNoFrances;

	@Column(length = 36, nullable = false)
	private String paiAbreviatura;

	public String getPaiAbreviatura() {
		return paiAbreviatura;
	}

	public void setPaiAbreviatura(String paiAbreviatura) {
		this.paiAbreviatura = paiAbreviatura;
	}

	public String getPaiNoFrances() {
		return paiNoFrances;
	}

	public void setPaiNoFrances(String paiNoFrances) {
		this.paiNoFrances = paiNoFrances;
	}

	public String getPaiNoIngles() {
		return paiNoIngles;
	}

	public void setPaiNoIngles(String paiNoIngles) {
		this.paiNoIngles = paiNoIngles;
	}

	public String getPaiNoPortugues() {
		return paiNoPortugues;
	}

	public void setPaiNoPortugues(String paiNoPortugues) {
		this.paiNoPortugues = paiNoPortugues;
	}

	public String getPaiSg() {
		return paiSg;
	}

	public void setPaiSg(String paiSg) {
		this.paiSg = paiSg;
	}

	public String getPaiSgAlternativa() {
		return paiSgAlternativa;
	}

	public void setPaiSgAlternativa(String paiSgAlternativa) {
		this.paiSgAlternativa = paiSgAlternativa;
	}

}

