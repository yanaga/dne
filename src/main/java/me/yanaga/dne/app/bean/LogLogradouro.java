package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class LogLogradouro implements Serializable {

    @Id
    @Column(nullable = false)
    private Integer logNu;

    @Column(length = 2)
    private String ufeSg;

    @Column(nullable = false)
    private Integer locNu;

    @Column(nullable = false)
    private Integer baiNuIni;

    @Column
    private Integer baiNuFim;

    @Column(length = 100, nullable = false)
    private String logNo;

    @Column(length = 100)
    private String logComplemento;

    @Column(length = 8, nullable = false)
    private String cep;

    @Column(length = 36, nullable = false)
    private String tloTx;

    @Column(length = 1)
    private String logStaTlo;

    @Column(length = 36)
    private String logNoAbrev;

    public Integer getBaiNuFim() {
        return baiNuFim;
    }

    public void setBaiNuFim(Integer baiNuFim) {
        this.baiNuFim = baiNuFim;
    }

    public Integer getBaiNuIni() {
        return baiNuIni;
    }

    public void setBaiNuIni(Integer baiNuIni) {
        this.baiNuIni = baiNuIni;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getLocNu() {
        return locNu;
    }

    public void setLocNu(Integer locNu) {
        this.locNu = locNu;
    }

    public String getLogComplemento() {
        return logComplemento;
    }

    public void setLogComplemento(String logComplemento) {
        this.logComplemento = logComplemento;
    }

    public String getLogNo() {
        return logNo;
    }

    public void setLogNo(String logNo) {
        this.logNo = logNo;
    }

    public String getLogNoAbrev() {
        return logNoAbrev;
    }

    public void setLogNoAbrev(String logNoAbrev) {
        this.logNoAbrev = logNoAbrev;
    }

    public Integer getLogNu() {
        return logNu;
    }

    public void setLogNu(Integer logNu) {
        this.logNu = logNu;
    }

    public String getLogStaTlo() {
        return logStaTlo;
    }

    public void setLogStaTlo(String logStaTlo) {
        this.logStaTlo = logStaTlo;
    }

    public String getTloTx() {
        return tloTx;
    }

    public void setTloTx(String tloTx) {
        this.tloTx = tloTx;
    }

    public String getUfeSg() {
        return ufeSg;
    }

    public void setUfeSg(String ufeSg) {
        this.ufeSg = ufeSg;
    }

}

