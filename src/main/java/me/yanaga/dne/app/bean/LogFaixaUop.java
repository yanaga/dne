package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(LogFaixaUopPK.class)
public class LogFaixaUop implements Serializable {

    @Id
    @Column(nullable = false)
    private Integer uopNu;

    @Id
    @Column(nullable = false)
    private Integer fncInicial;

    @Column(nullable = false)
    private Integer fncFinal;

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

