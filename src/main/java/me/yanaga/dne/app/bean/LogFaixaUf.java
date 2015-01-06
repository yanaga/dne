package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(LogFaixaUfPK.class)
public class LogFaixaUf implements Serializable {

    @Id
    @Column(length = 2, nullable = false)
    private String ufeSg;

    @Id
    @Column(length = 8, nullable = false)
    private String ufeCepIni;

    @Column(length = 8, nullable = false)
    private String ufeCepFim;

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

