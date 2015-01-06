package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(LogVarLogPK.class)
public class LogVarLog implements Serializable {

    @Id
    @Column(nullable = false)
    private Integer logNu;

    @Id
    @Column(nullable = false)
    private Integer vloNu;

    @Column(length = 36, nullable = false)
    private String tloTx;

    @Column(length = 150, nullable = false)
    private String vloTx;

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

