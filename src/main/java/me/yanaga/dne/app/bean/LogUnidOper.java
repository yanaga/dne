package me.yanaga.dne.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class LogUnidOper implements Serializable {

    @Id
    @Column(nullable = false)
    private Integer uopNu;

    @Column(length = 2, nullable = false)
    private String ufeSg;

    @Column(nullable = false)
    private Integer locNu;

    @Column(nullable = false)
    private Integer baiNu;

    @Column
    private Integer logNu;

    @Column(length = 100, nullable = false)
    private String uopNo;

    @Column(length = 100, nullable = false)
    private String uopEndereco;

    @Column(length = 8, nullable = false)
    private String cep;

    @Column(length = 1, nullable = false)
    private String uopInCp;

    @Column(length = 36)
    private String uopNoAbrev;

    public Integer getBaiNu() {
        return baiNu;
    }

    public void setBaiNu(Integer baiNu) {
        this.baiNu = baiNu;
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

    public Integer getLogNu() {
        return logNu;
    }

    public void setLogNu(Integer logNu) {
        this.logNu = logNu;
    }

    public String getUfeSg() {
        return ufeSg;
    }

    public void setUfeSg(String ufeSg) {
        this.ufeSg = ufeSg;
    }

    public String getUopEndereco() {
        return uopEndereco;
    }

    public void setUopEndereco(String uopEndereco) {
        this.uopEndereco = uopEndereco;
    }

    public String getUopInCp() {
        return uopInCp;
    }

    public void setUopInCp(String uopInCp) {
        this.uopInCp = uopInCp;
    }

    public String getUopNo() {
        return uopNo;
    }

    public void setUopNo(String uopNo) {
        this.uopNo = uopNo;
    }

    public String getUopNoAbrev() {
        return uopNoAbrev;
    }

    public void setUopNoAbrev(String uopNoAbrev) {
        this.uopNoAbrev = uopNoAbrev;
    }

    public Integer getUopNu() {
        return uopNu;
    }

    public void setUopNu(Integer uopNu) {
        this.uopNu = uopNu;
    }

}

