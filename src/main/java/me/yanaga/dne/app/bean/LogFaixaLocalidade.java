package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(LogFaixaLocalidadePK.class)
public class LogFaixaLocalidade implements Serializable {

    @Id
    @Column(nullable = false)
    private Integer locNu;

    @Id
    @Column(length = 8, nullable = false)
    private String locCepIni;

    @Column(length = 8, nullable = false)
    private String locCepFim;

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

