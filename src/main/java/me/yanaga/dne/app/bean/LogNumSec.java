package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class LogNumSec implements Serializable {

    @Id
    @Column(nullable = false)
    private Integer logNu;

    @Column(length = 10, nullable = false)
    private String secNuIni;

    @Column(length = 10, nullable = false)
    private String secNuFim;

    @Column(length = 1, nullable = false)
    private String secInLado;

    public Integer getLogNu() {
        return logNu;
    }

    public void setLogNu(Integer logNu) {
        this.logNu = logNu;
    }

    public String getSecInLado() {
        return secInLado;
    }

    public void setSecInLado(String secInLado) {
        this.secInLado = secInLado;
    }

    public String getSecNuFim() {
        return secNuFim;
    }

    public void setSecNuFim(String secNuFim) {
        this.secNuFim = secNuFim;
    }

    public String getSecNuIni() {
        return secNuIni;
    }

    public void setSecNuIni(String secNuIni) {
        this.secNuIni = secNuIni;
    }

}

