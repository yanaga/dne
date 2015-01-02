package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class LogFaixaUf implements Serializable {

    @EmbeddedId
    private LogFaixaUfPK id;

    @Column(insertable = false, updatable = false)
    private String ufeSg;

    @Column(insertable = false, updatable = false)
    private String ufeCepIni;

    @Column(length = 8, nullable = false)
    private String ufeCepFim;

    public LogFaixaUfPK getId() {
        return id;
    }

    public void setId(LogFaixaUfPK id) {
        this.id = id;
    }

    public String getUfeSg() {
        return ufeSg;
    }

    public void setUfeSg(String ufeSg) {
        this.ufeSg = ufeSg;
    }

    public String getUfeCepIni() {
        return ufeCepIni;
    }

    public void setUfeCepIni(String ufeCepIni) {
        this.ufeCepIni = ufeCepIni;
    }

    public String getUfeCepFim() {
        return ufeCepFim;
    }

    public void setUfeCepFim(String ufeCepFim) {
        this.ufeCepFim = ufeCepFim;
    }
}

