package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class LogFaixaUop implements Serializable {

    @EmbeddedId
    private LogFaixaUopPK id;

    @Column(insertable = false, updatable = false)
    private Integer uopNu;

    @Column(insertable = false, updatable = false)
    private Integer fncInicial;

    @Column(nullable = false)
    private Integer fncFinal;

    public LogFaixaUopPK getId() {
        return id;
    }

    public void setId(LogFaixaUopPK id) {
        this.id = id;
    }

    public Integer getUopNu() {
        return uopNu;
    }

    public void setUopNu(Integer uopNu) {
        this.uopNu = uopNu;
    }

    public Integer getFncInicial() {
        return fncInicial;
    }

    public void setFncInicial(Integer fncInicial) {
        this.fncInicial = fncInicial;
    }

    public Integer getFncFinal() {
        return fncFinal;
    }

    public void setFncFinal(Integer fncFinal) {
        this.fncFinal = fncFinal;
    }
}

