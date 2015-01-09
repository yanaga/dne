package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(LogVarLocPK.class)
public class LogVarLoc implements Serializable {

    @Id
    @Column(nullable = false)
	private Integer locNu;

    @Id
	@Column(nullable = false)
	private Integer valNu;

    @Column(length = 72, nullable = false)
    private String valTx;

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

    public String getValTx() {
        return valTx;
    }

    public void setValTx(String valTx) {
        this.valTx = valTx;
    }

}

