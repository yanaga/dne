package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class LogVarLog implements Serializable {

    @EmbeddedId
    private LogVarLogPK id;

    @Column(insertable = false, updatable = false)
    private Integer logNu;

    @Column(insertable = false, updatable = false)
    private Integer vloNu;

    @Column(length = 36, nullable = false)
    private String tloTx;

    @Column(length = 150, nullable = false)
    private String vloTx;

    public LogVarLogPK getId() {
        return id;
    }

    public void setId(LogVarLogPK id) {
        this.id = id;
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

    public String getTloTx() {
        return tloTx;
    }

    public void setTloTx(String tloTx) {
        this.tloTx = tloTx;
    }

    public String getVloTx() {
        return vloTx;
    }

    public void setVloTx(String vloTx) {
        this.vloTx = vloTx;
    }

}

