package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class LogFaixaLocalidade implements Serializable {

    @EmbeddedId
    private LogFaixaLocalidadePK id;

    @Column(insertable = false, updatable = false)
    private Integer locNu;

    @Column(insertable = false, updatable = false)
    private String locCepIni;

    @Column(length = 8, nullable = false)
    private String locCepFim;

    public LogFaixaLocalidadePK getId() {
        return id;
    }

    public void setId(LogFaixaLocalidadePK id) {
        this.id = id;
    }

    public Integer getLocNu() {
        return locNu;
    }

    public void setLocNu(Integer locNu) {
        this.locNu = locNu;
    }

    public String getLocCepIni() {
        return locCepIni;
    }

    public void setLocCepIni(String locCepIni) {
        this.locCepIni = locCepIni;
    }

    public String getLocCepFim() {
        return locCepFim;
    }

    public void setLocCepFim(String locCepFim) {
        this.locCepFim = locCepFim;
    }
}

