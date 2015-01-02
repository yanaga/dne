package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class LogVarLoc implements Serializable {

    @EmbeddedId
    private LogVarLocPK id;

    @Column(insertable = false, updatable = false)
    private Integer locNu;

    @Column(insertable = false, updatable = false)
    private Integer valNu;

    @Column(length = 72, nullable = false)
    private String valTx;

    public LogVarLocPK getId() {
        return id;
    }

    public void setId(LogVarLocPK id) {
        this.id = id;
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

    public String getValTx() {
        return valTx;
    }

    public void setValTx(String valTx) {
        this.valTx = valTx;
    }

}

