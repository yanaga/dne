package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class LogFaixaBairro implements Serializable {

    public static final String FILE_NAME = "LOG_FAIXA_BAIRRO";

    @EmbeddedId
    private LogFaixaBairroPK id;

    @Column(insertable = false, updatable = false)
    private Integer baiNu;

    @Column(insertable = false, updatable = false)
    private String fcbCepIni;

    @Column(length = 8, nullable = false)
    private String fcbCepFim;

    public LogFaixaBairroPK getId() {
        return id;
    }

    public void setId(LogFaixaBairroPK id) {
        this.id = id;
    }

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

