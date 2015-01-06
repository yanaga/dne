package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(LogFaixaBairroPK.class)
public class LogFaixaBairro implements Serializable {

    @Id
    @Column(nullable = false)
    private Integer baiNu;

    @Id
    @Column(length = 8, nullable = false)
    private String fcbCepIni;

    @Column(length = 8, nullable = false)
    private String fcbCepFim;

    public Integer getBaiNu() {
        return baiNu;
    }

    public void setBaiNu(Integer baiNu) {
        this.baiNu = baiNu;
    }

    public String getFcbCepIni() {
        return fcbCepIni;
    }

    public void setFcbCepIni(String fcbCepIni) {
        this.fcbCepIni = fcbCepIni;
    }

    public String getFcbCepFim() {
        return fcbCepFim;
    }

    public void setFcbCepFim(String fcbCepFim) {
        this.fcbCepFim = fcbCepFim;
    }

}

